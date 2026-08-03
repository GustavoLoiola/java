package com.easyconvert.service.conversion;

import com.easyconvert.exception.FileConversionException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * Responsavel por todas as operacoes de armazenamento fisico de arquivos:
 * salvar o upload original e localizar os arquivos ja convertidos.
 *
 * Mantida separada da logica de conversao de proposito: essa classe nao
 * sabe nada sobre PDF/DOCX/LibreOffice — ela so entende "salvar arquivo",
 * "ler diretorio", "montar caminho". Se um dia trocarmos armazenamento
 * local por S3, por exemplo, so essa classe muda.
 */
@Slf4j
@Service
public class FileStorageService {

    @Value("${app.storage.upload-dir}")
    private String uploadDir;

    @Value("${app.storage.converted-dir}")
    private String convertedDir;

    private Path uploadPath;
    private Path convertedPath;

    /**
     * Executado uma vez, na inicializacao da aplicacao: garante que os
     * diretorios de armazenamento existem antes de qualquer upload chegar.
     */
    @PostConstruct
    public void init() {
        try {
            uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            convertedPath = Paths.get(convertedDir).toAbsolutePath().normalize();

            Files.createDirectories(uploadPath);
            Files.createDirectories(convertedPath);

            log.info("Diretorio de uploads: {}", uploadPath);
            log.info("Diretorio de arquivos convertidos: {}", convertedPath);
        } catch (IOException ex) {
            throw new IllegalStateException("Nao foi possivel criar os diretorios de armazenamento", ex);
        }
    }

    /**
     * Salva o arquivo enviado pelo usuario em disco, com um nome unico
     * (evita que dois usuarios enviando "documento.pdf" ao mesmo tempo
     * sobrescrevam o arquivo um do outro).
     */
    public Path store(MultipartFile file) {
        String uniqueFilename = generateUniqueFilename(file.getOriginalFilename());
        Path destination = uploadPath.resolve(uniqueFilename);

        try {
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
            return destination;
        } catch (IOException ex) {
            throw new FileConversionException("Falha ao salvar o arquivo enviado.", ex);
        }
    }

    public Path getConvertedDirectory() {
        return convertedPath;
    }

    public Path resolveConvertedFile(String filename) {
        return convertedPath.resolve(filename).normalize();
    }

    public void deleteQuietly(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            log.warn("Nao foi possivel remover o arquivo temporario: {}", path, ex);
        }
    }

    private String generateUniqueFilename(String originalFilename) {
        String sanitized = originalFilename == null
                ? "arquivo"
                : originalFilename.replaceAll("[^a-zA-Z0-9._-]", "_");

        return UUID.randomUUID() + "_" + sanitized;
    }

}
