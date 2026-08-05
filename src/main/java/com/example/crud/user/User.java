package com.example.crud.user;

import com.example.crud.enums.Cargo;
import com.example.crud.enums.Role;
import com.example.crud.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nome;

    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

    @Column(nullable = false, name = "empresa_id")
    private Long empresaId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USUARIO;
}
