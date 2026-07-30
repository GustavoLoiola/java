package com.easyconvert.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String email) {
        super("Já existe uma conta cadastrada com o e-mail: " + email);
    }
}
