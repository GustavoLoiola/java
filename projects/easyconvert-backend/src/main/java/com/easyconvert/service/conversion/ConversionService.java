package com.easyconvert.service.conversion;

import com.easyconvert.dto.response.ConversionResponse;
import com.easyconvert.entity.ConversionHistory;
import com.easyconvert.entity.ConversionStatus;
import com.easyconvert.entity.ConversionType;
import com.easyconvert.exception.FileConversionException;
import com.easyconvert.exception.ResourceNotFoundException;
import com.easyconvert.repository.ConversionHistoryRepository;
import com.easyconvert.repository.UserRepository;
import com.easyconvert.service.conversion.conversion.ConversionStrategy;
import com.easyconvert.service.conversion.conversion.ConversionStrategyFactory;
import com.easyconvert.util.FileValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionService {

    private final FileValidator fileValidator;
    private final FileStorageService fileStorageService;
    private final ConversionStrategyFactory strategyFactory;
    private final ConversionHistoryRepository conversionHistoryRepository;
    private final UserRepository userRepository;

    /**
     * Executa uma conversao de arquivo de ponta a ponta.
     *
     * Nao e anotado com @Transactional de proposito: a conversao aciona
     * um processo externo (LibreOffice) que pode levar varios segundos.
     * Manter uma transacao de banco aberta durante todo esse tempo
     * prenderia uma conexao do pool desnecessariamente. Em vez disso,
     * cada chamada a repository.save(...) e transacional por conta
     * propria (comportamento padrao do Spring Data JPA).
     */
    public ConversionResponse convert(MultipartFile file, ConversionType type, Long userId) {
        fileValidator.validate(file, type);

        Path storedInput = fileStorageService.store(file);

        ConversionHistory history = ConversionHistory.builder()
                // getReferenceById monta uma referencia (proxy) para o usuario
                // sem precisar buscar a linha inteira no banco - so precisamos
                // do id para a chave estrangeira.
                .user(userRepository.getReferenceById(userId))
                .originalFilename(file.getOriginalFilename())
                .conversionType(type)
                .status(ConversionStatus.PENDING)
                .build();

        history = conversionHistoryRepository.save(history);

        try {
            ConversionStrategy strategy = strategyFactory.getStrategy(type);
            Path convertedFile = strategy.convert(storedInput, fileStorageService.getConvertedDirectory());

            history.setConvertedFilename(convertedFile.getFileName().toString());
            history.setStatus(ConversionStatus.SUCCESS);

            log.info("Conversao {} concluida para o usuario {}", type, userId);

        } catch (FileConversionException ex) {
            // Nao relancamos a excecao aqui: preferimos devolver uma resposta
            // 201 com status FAILED e a mensagem de erro, para que o
            // front-end mostre o problema no historico em vez de um erro
            // HTTP generico. O registro no historico documenta a falha.
            history.setStatus(ConversionStatus.FAILED);
            history.setErrorMessage(ex.getMessage());

            log.error("Falha ao converter arquivo do usuario {}", userId, ex);

        } finally {
            // O arquivo original enviado pelo usuario nao precisa mais
            // ficar em disco depois da tentativa de conversao.
            fileStorageService.deleteQuietly(storedInput);
        }

        ConversionHistory saved = conversionHistoryRepository.save(history);
        return toResponse(saved);
    }

    public List<ConversionResponse> getHistory(Long userId) {
        return conversionHistoryRepository.findByUserIdOrderByCreatedAtDesc(userId).stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Resolve os dados necessarios para o download de um arquivo convertido,
     * garantindo que o registro pertence ao usuario autenticado (evita que
     * um usuario baixe conversoes de outro apenas adivinhando o id).
     */
    public ConversionDownload getDownload(Long conversionId, Long userId) {
        ConversionHistory history = conversionHistoryRepository.findByIdAndUserId(conversionId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Conversao nao encontrada ou nao pertence ao usuario atual."));

        if (history.getStatus() != ConversionStatus.SUCCESS || history.getConvertedFilename() == null) {
            throw new ResourceNotFoundException(
                    "Esta conversao nao possui um arquivo disponivel para download.");
        }

        Path filePath = fileStorageService.resolveConvertedFile(history.getConvertedFilename());

        if (!Files.exists(filePath)) {
            throw new ResourceNotFoundException("O arquivo convertido nao foi encontrado no servidor.");
        }

        return new ConversionDownload(filePath, buildDownloadFilename(history));
    }

    /**
     * Monta um nome de arquivo "amigavel" para o download, baseado no nome
     * original enviado pelo usuario (o nome fisico salvo em disco tem um
     * prefixo UUID que nao faz sentido mostrar para o usuario final).
     */
    private String buildDownloadFilename(ConversionHistory history) {
        String original = history.getOriginalFilename();

        String baseName = (original != null && original.contains("."))
                ? original.substring(0, original.lastIndexOf('.'))
                : "arquivo_convertido";

        String newExtension = history.getConversionType() == ConversionType.PDF_TO_DOCX ? "docx" : "pdf";

        return baseName + "." + newExtension;
    }

    private ConversionResponse toResponse(ConversionHistory history) {
        return ConversionResponse.builder()
                .id(history.getId())
                .originalFilename(history.getOriginalFilename())
                .convertedFilename(history.getConvertedFilename())
                .conversionType(history.getConversionType())
                .status(history.getStatus())
                .errorMessage(history.getErrorMessage())
                .createdAt(history.getCreatedAt())
                .build();
    }

}
