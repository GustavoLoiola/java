package com.easyconvert.controller;

import com.easyconvert.security.UserPrincipal;
import com.easyconvert.service.conversion.ConversionDownload;
import com.easyconvert.service.conversion.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Responsavel exclusivamente por servir (stream) o arquivo convertido
 * para download. Separado do ConversionController porque lida com um
 * tipo de resposta bem diferente (bytes de arquivo, nao JSON).
 */
@RestController
@RequestMapping("/api/conversions")
@RequiredArgsConstructor
public class FileController {

    private final ConversionService conversionService;

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> download(
            @PathVariable Long id,
            @AuthenticationPrincipal UserPrincipal principal) {

        // getDownload ja valida que a conversao pertence ao usuario logado
        // (findByIdAndUserId, la no ConversionHistoryRepository) — protecao
        // contra um usuario tentar baixar o arquivo de outro so trocando o id.
        ConversionDownload download = conversionService.getDownload(id, principal.getId());

        Resource resource = new FileSystemResource(download.filePath());
        String contentType = probeContentType(download.filePath());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + download.downloadFilename() + "\"")
                .body(resource);
    }

    private String probeContentType(Path path) {
        try {
            String type = Files.probeContentType(path);
            return type != null ? type : MediaType.APPLICATION_OCTET_STREAM_VALUE;
        } catch (IOException ex) {
            return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }

}
