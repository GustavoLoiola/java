package com.easyconvert.service.conversion;

import java.nio.file.Path;

public record ConversionDownload(Path filePath, String downloadFilename) {}