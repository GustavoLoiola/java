package com.easyconvert.service.conversion.conversion;

import com.easyconvert.exception.FileConversionException;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractLibreOfficeConverter implements ConversionStrategy {

    @Value("${app.conversion.soffice-path}")
    private String sofficePath;

    @Value("${app.conversion.timeout-seconds}")
    private long timeoutSeconds;

    protected abstract String getTargetFormat();

    @Override
    public Path convert(Path inputFile, Path outputDir) {

        validateInputExists(inputFile);

        try {

            List<String> command = List.of(
                    sofficePath,
                    "--headless",
                    "--norestore",
                    "--convert-to",
                    getTargetFormat(),
                    "--outdir",
                    outputDir.toAbsolutePath().toString(),
                    inputFile.toAbsolutePath().toString()
            );

            Process process = new ProcessBuilder(command)
                    .redirectErrorStream(true)
                    .start();

            boolean finishedInTime =
                    process.waitFor(timeoutSeconds, TimeUnit.SECONDS);

            if (!finishedInTime) {
                process.destroyForcibly();
                throw new FileConversionException(
                        "A conversão excedeu o tempo limite."
                );
            }

            if (process.exitValue() != 0) {
                throw new FileConversionException(
                        "Erro durante a conversão do arquivo."
                );
            }

            return resolveConvertedFile(inputFile, outputDir);

        } catch (IOException e) {
            throw new FileConversionException(
                    "Erro ao executar o LibreOffice.",
                    e
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new FileConversionException(
                    "A conversão foi interrompida.",
                    e
            );
        }
    }

    protected void validateInputExists(Path inputFile) {

        if (inputFile == null || !Files.exists(inputFile)) {
            throw new FileConversionException("Arquivo de entrada não encontrado.");
        }

    }

    protected Path resolveConvertedFile(Path inputFile, Path outputDir) {

        String fileName = inputFile.getFileName().toString();

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }

        fileName += "." + getTargetFormat();

        return outputDir.resolve(fileName);
    }
}