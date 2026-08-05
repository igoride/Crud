package com.example.crud.auth.service;

import com.example.crud.auth.dto.LoginDTO;
import com.example.crud.auth.dto.LoginResponseDTO;
import com.example.crud.user.User;

public interface AuthService {

    User cadastro (LoginDTO loginDTO);

    LoginResponseDTO login (LoginDTO loginDTO);
}
