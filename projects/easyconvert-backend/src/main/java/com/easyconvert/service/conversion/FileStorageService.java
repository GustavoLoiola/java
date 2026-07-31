package com.easyconvert.service.conversion;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${app.storage.upload-dir}")
    private String uploadDir;

    @Value("${app.storage.converted-dir}")
    private String convertedDir;

    private Path uploadPath;
    private Path convertedPath;

    @PostConstruct
    public void init() {
        try {
            uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            convertedPath = Paths.get(convertedDir).toAbsolutePath().normalize();

            Files.createDirectories(uploadPath);
            Files.createDirectories(convertedPath);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar os diretórios de armazenamento.", e);
        }
    }

    public Path store(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("O arquivo está vazio.");
        }

        try {
            String uniqueFilename = generateUniqueFilename(file.getOriginalFilename());
            Path destination = uploadPath.resolve(uniqueFilename);

            Files.copy(file.getInputStream(), destination,
                    StandardCopyOption.REPLACE_EXISTING);

            return destination;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o arquivo.", e);
        }
    }

    private String generateUniqueFilename(String originalFilename) {
        String sanitized = originalFilename == null
                ? "arquivo"
                : Paths.get(originalFilename)
                  .getFileName()
                  .toString()
                  .replaceAll("[^a-zA-Z0-9._-]", "_");

        return UUID.randomUUID() + "_" + sanitized;
    }
}