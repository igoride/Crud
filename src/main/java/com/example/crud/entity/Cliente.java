package com.example.crud.entity;

import com.example.crud.enums.TipoPessoa;
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
@Table(name = "clientes")
public class Cliente extends BaseEntity{

    @Column(nullable = false)
    private String nome;

    private String telefone;

    @Column(nullable = false)
    private String cpf;

    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

}
