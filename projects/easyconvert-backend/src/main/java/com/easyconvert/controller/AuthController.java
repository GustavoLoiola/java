package com.easyconvert.controller;

import com.easyconvert.dto.request.LoginRequest;
import com.easyconvert.dto.request.RegisterRequest;
import com.easyconvert.dto.response.AuthResponse;
import com.easyconvert.dto.response.UserResponse;
import com.easyconvert.security.UserPrincipal;
import com.easyconvert.service.AuthService;
import com.easyconvert.service.conversion.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Endpoints de autenticacao: cadastro, login, logout e dados do
 * usuario autenticado.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Rota protegida: so pode ser chamada com um token valido no header
     * Authorization. O @AuthenticationPrincipal injeta automaticamente
     * o usuario que o JwtAuthenticationFilter colocou no SecurityContext.
     */
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@AuthenticationPrincipal UserPrincipal principal) {
        authService.logout(principal.getEmail());
        return ResponseEntity.ok(Map.of(
                "message", "Logout realizado com sucesso. Remova o token armazenado no cliente."
        ));
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(@AuthenticationPrincipal UserPrincipal principal) {
        UserResponse response = userService.getCurrentUserProfile(principal.getEmail());
        return ResponseEntity.ok(response);
    }

}
