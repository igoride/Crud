package com.example.crud.parceiro.service;

import com.example.crud.parceiro.dto.ParceiroRequestDTO;
import com.example.crud.shared.MessageResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ParceiroService {
    ResponseEntity<MessageResponseDTO> cadastroParceiro(@Valid ParceiroRequestDTO parceiroRequestDTO);

    ResponseEntity<MessageResponseDTO> atualizarParceiro(@Valid ParceiroRequestDTO parceiroRequestDTO, UUID parceiroUuid);

    ResponseEntity<MessageResponseDTO> desativarParceiro(UUID parceiroUuid);
}
