package com.example.crud.fornecedor;

import com.example.crud.parceiro.entity.Parceiro;
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
@Table(name = "fornecedores")
public class Fornecedor {

    @OneToOne
    @JoinColumn(name = "parceiro_id", nullable = false, unique = true)
    private Parceiro parceiro;

}
