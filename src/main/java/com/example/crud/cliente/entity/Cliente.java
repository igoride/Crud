package com.example.crud.cliente.entity;

import com.example.crud.parceiro.entity.Parceiro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "parceiro_id")
    private Long parceiroId;

    @OneToOne
    @MapsId
    private Parceiro parceiro;

    private BigDecimal saldo;

}
