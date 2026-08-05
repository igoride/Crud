package com.example.crud.parceiro.repository;

import com.example.crud.parceiro.entity.Parceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {
}
