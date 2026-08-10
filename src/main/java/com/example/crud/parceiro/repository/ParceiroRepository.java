package com.example.crud.parceiro.repository;

import com.example.crud.parceiro.entity.Parceiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {
    boolean existsByCpfCnpj(String s);

    Optional<Parceiro> findByUuid(UUID parceiroUuid);
}
