package com.easyconvert.controller;

import com.easyconvert.dto.response.ConversionResponse;
import com.easyconvert.entity.ConversionType;
import com.easyconvert.security.UserPrincipal;
import com.easyconvert.service.conversion.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Endpoints relacionados a conversao de arquivos: envio (upload) e
 * consulta do historico. O download do arquivo em si fica em
 * FileController — separado de proposito, pois lida com streaming de
 * bytes em vez de JSON.
 */
@RestController
@RequestMapping("/api/conversions")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    /**
     * Recebe o arquivo via multipart/form-data junto com o tipo de
     * conversao desejado (PDF_TO_DOCX ou DOCX_TO_PDF) e devolve o
     * registro da conversao resultante — mesmo que ela tenha falhado
     * (nesse caso, o campo "status" vem como FAILED e "errorMessage"
     * explica o motivo).
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ConversionResponse> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") ConversionType type,
            @AuthenticationPrincipal UserPrincipal principal) {

        ConversionResponse response = conversionService.convert(file, type, principal.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<ConversionResponse>> history(
            @AuthenticationPrincipal UserPrincipal principal) {

        List<ConversionResponse> history = conversionService.getHistory(principal.getId());
        return ResponseEntity.ok(history);
    }

}
