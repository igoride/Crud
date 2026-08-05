package com.example.crud.auth;

import com.example.crud.user.User;

public interface AuthService {

    User cadastro (LoginDTO loginDTO);

    LoginResponseDTO login (LoginDTO loginDTO);
}
