package com.easyconvert.util;

import com.easyconvert.entity.ConversionType;
import com.easyconvert.exception.InvalidFileTypeException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;


@Component
public class FileValidator {

    private static final long MAX_FILE_SIZE_BYTES = 25L * 1024 * 1024;

    public void validate(MultipartFile file, ConversionType conversionType) {
        if (file == null || file.isEmpty()) {
            throw new InvalidFileTypeException("Nenhum arquivo foi enviado.");
        }

        if (file.getSize() > MAX_FILE_SIZE_BYTES) {
            throw new InvalidFileTypeException("O arquivo excede o tamanho maximo permitido (25MB).");
        }

        String extension = extractExtension(file.getOriginalFilename());
        String expectedExtension = expectedExtensionFor(conversionType);

        if (!expectedExtension.equalsIgnoreCase(extension)) {
            throw new InvalidFileTypeException(
                    "Para a conversao " + conversionType + ", o arquivo enviado deve ter extensao ."
                            + expectedExtension + " (recebido: ." + extension + ")");
        }
    }

    private String expectedExtensionFor(ConversionType conversionType) {
        return switch (conversionType) {
            case PDF_TO_DOCX -> "pdf";
            case DOCX_TO_PDF -> "docx";
        };
    }

    private String extractExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            throw new InvalidFileTypeException("Nao foi possivel identificar a extensao do arquivo enviado.");
        }
        return filename.substring(filename.lastIndexOf('.') + 1).toLowerCase(Locale.ROOT);
    }
}
