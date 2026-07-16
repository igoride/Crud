package com.example.crud.service;

import com.example.crud.Entity.User;
import com.example.crud.dto.LoginDTO;
import com.example.crud.dto.LoginResponseDTO;

public interface AuthService {

    User cadastro (LoginDTO loginDTO);

    LoginResponseDTO login (LoginDTO loginDTO);
}
