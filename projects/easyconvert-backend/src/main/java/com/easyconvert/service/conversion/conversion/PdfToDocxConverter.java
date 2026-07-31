package com.easyconvert.service.conversion.conversion;

import com.easyconvert.entity.ConversionType;
import org.springframework.stereotype.Component;

@Component
public class PdfToDocxConverter extends AbstractLibreOfficeConverter {
    @Override
    public ConversionType getType() { return ConversionType.PDF_TO_DOCX; }

    @Override
    protected String getTargetFormat() { return "docx"; }
}