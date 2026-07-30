package com.easyconvert.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "O e-mail e obrigatorio")
    @Email(message = "Informe um e-mail valido")
    @Size(max = 150, message = "O e-mail deve ter no maximo 150 caracteres")
    private String email;

    @NotBlank(message = "A senha e obrigatoria")
    @Size(min = 6, max = 100, message = "A senha deve ter no minimo 6 caracteres")
    private String password;
}