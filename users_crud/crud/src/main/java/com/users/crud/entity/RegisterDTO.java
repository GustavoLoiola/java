package com.users.crud.entity;

import java.time.LocalDate;

public record RegisterDTO(
        String name,
        String email,
        LocalDate birthDate,
        String password,
        UserRole role
) {}