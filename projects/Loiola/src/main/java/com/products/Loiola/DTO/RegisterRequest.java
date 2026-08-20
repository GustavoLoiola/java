package com.products.Loiola.DTO;

import com.products.Loiola.Model.UserRole;

public record RegisterRequest(String name, String email, String phone, String password, UserRole role) {
}
