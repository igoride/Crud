package com.example.crud.service.impl;

import com.example.crud.Entity.User;
import com.example.crud.dto.LoginDTO;
import com.example.crud.dto.LoginResponseDTO;
import com.example.crud.repository.UserRepository;
import com.example.crud.security.JwtService;
import com.example.crud.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService service;
    private final AuthenticationManager manager;

    @Override
    public User cadastro(LoginDTO loginDTO) {
        User user = new User();
        user.setUsername(loginDTO.getUsername());
        user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword())
        );

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(loginDTO.getUsername())
                .password("")
                .roles("USER")
                .build();

        String token = service.generateToken(userDetails);
        return new LoginResponseDTO(token);
    }
}
