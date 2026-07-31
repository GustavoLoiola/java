package com.easyconvert.service.conversion.conversion;

import com.easyconvert.entity.ConversionType;
import com.easyconvert.service.conversion.conversion.AbstractLibreOfficeConverter;
import org.springframework.stereotype.Component;

@Component
public class DocxToPdfConverter extends AbstractLibreOfficeConverter {

    @Override
    public ConversionType getType() {
        return ConversionType.DOCX_TO_PDF;
    }

    @Override
    protected String getTargetFormat() {
        return "pdf";
    }

}
