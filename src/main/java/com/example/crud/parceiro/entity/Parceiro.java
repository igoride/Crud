package com.example.crud.parceiro.entity;

import com.example.crud.shared.BaseEntity;
import com.example.crud.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parceiros")
public class Parceiro extends BaseEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpfCnpj;

    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
}
