package com.easyconvert.service.conversion.conversion;

import com.easyconvert.entity.ConversionType;

import java.nio.file.Path;

public interface ConversionStrategy {
    ConversionType getType();
    Path convert(Path inputFile, Path outputDir);
}