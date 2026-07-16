package com.example.crud.service;

import com.example.crud.Entity.User;
import com.example.crud.dto.auth.LoginDTO;
import com.example.crud.dto.auth.LoginResponseDTO;

public interface AuthService {

    User cadastro (LoginDTO loginDTO);

    LoginResponseDTO login (LoginDTO loginDTO);
}
