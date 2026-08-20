package com.products.Loiola.Controller;

import com.products.Loiola.DTO.LoginRequest;
import com.products.Loiola.DTO.LoginResponse;
import com.products.Loiola.DTO.RegisterRequest;
import com.products.Loiola.Model.User;
import com.products.Loiola.Repository.UserRepository;
import com.products.Loiola.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = this.authService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest data) {
        if (this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado no sistema.");
        }

        // Criptografa a senha antes de salvar
        String encryptedPassword = passwordEncoder.encode(data.password());

        // Construtor: (name, email, password, phone, role)
        User newUser = new User(
                data.name(),
                data.email(),
                encryptedPassword,
                data.phone(),
                data.role()
        );

        this.userRepository.save(newUser);

        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
}
