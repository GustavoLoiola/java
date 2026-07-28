package com.easyconvert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal responsavel por inicializar a aplicacao EasyConvert.
 *
 * A aplicacao expoe uma API REST para:
 * - Autenticacao de usuarios (JWT)
 * - Upload e conversao de arquivos (PDF <-> DOCX)
 * - Download de arquivos convertidos
 * - Historico de conversoes por usuario
 */
@SpringBootApplication
public class EasyConvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyConvertApplication.class, args);
    }

}
