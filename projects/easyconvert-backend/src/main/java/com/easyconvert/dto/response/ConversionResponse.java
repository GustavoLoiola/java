package com.easyconvert.dto.response;

import com.easyconvert.entity.ConversionStatus;
import com.easyconvert.entity.ConversionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversionResponse {

    private Long id;
    private String originalFilename;
    private String convertedFilename;
    private ConversionType conversionType;
    private ConversionStatus status;
    private String errorMessage;
    private LocalDateTime createdAt;

}
