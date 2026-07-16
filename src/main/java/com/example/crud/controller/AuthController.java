package com.example.crud.controller;

import com.example.crud.Entity.User;
import com.example.crud.dto.LoginDTO;
import com.example.crud.dto.LoginResponseDTO;
import com.example.crud.service.AuthService;
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
    public User cadastro(@RequestBody LoginDTO loginDTO) {
        return service.cadastro(loginDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO loginDTO) {
        return service.login(loginDTO);
    }

}
