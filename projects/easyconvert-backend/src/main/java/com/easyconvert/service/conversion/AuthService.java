package com.easyconvert.service;

import com.easyconvert.dto.request.LoginRequest;
import com.easyconvert.dto.request.RegisterRequest;
import com.easyconvert.dto.response.AuthResponse;
import com.easyconvert.dto.response.UserResponse;
import com.easyconvert.entity.Role;
import com.easyconvert.entity.User;
import com.easyconvert.exception.EmailAlreadyInUseException;
import com.easyconvert.repository.UserRepository;
import com.easyconvert.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyInUseException(request.getEmail());
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        User savedUser = userRepository.save(user);
        log.info("Novo usuario cadastrado: {}", savedUser.getEmail());

        String token = jwtTokenProvider.generateToken(savedUser.getEmail());

        return buildAuthResponse(token, savedUser);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalStateException(
                        "Usuario autenticado nao encontrado no banco: " + request.getEmail()));

        String token = jwtTokenProvider.generateToken(user.getEmail());

        log.info("Login realizado: {}", user.getEmail());

        return buildAuthResponse(token, user);
    }

    public void logout(String email) {
        log.info("Logout solicitado por: {}", email);
    }

    private AuthResponse buildAuthResponse(String token, User user) {
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build();

        return AuthResponse.builder()
                .token(token)
                .user(userResponse)
                .build();
    }

}
