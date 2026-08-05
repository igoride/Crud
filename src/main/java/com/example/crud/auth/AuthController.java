package com.example.crud.auth;

import com.example.crud.auth.dto.LoginDTO;
import com.example.crud.auth.dto.LoginResponseDTO;
import com.example.crud.auth.service.AuthService;
import com.example.crud.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/cadastro")
    public User cadastro(@Valid @RequestBody LoginDTO loginDTO) {
        return service.cadastro(loginDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginDTO loginDTO) {
        return service.login(loginDTO);
    }

}
