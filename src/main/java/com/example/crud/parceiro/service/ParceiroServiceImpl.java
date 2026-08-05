package com.example.crud.parceiro.service;

import com.example.crud.parceiro.dto.ParceiroRequestDTO;
import com.example.crud.shared.MessageResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class ParceiroServiceImpl implements ParceiroService {
    @Override
    public ResponseEntity<MessageResponseDTO> cadastroParceiro(ParceiroRequestDTO parceiroRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<MessageResponseDTO> atualizarParceiro(ParceiroRequestDTO parceiroRequestDTO, UUID parceiroUuid) {
        return null;
    }

    @Override
    public ResponseEntity<MessageResponseDTO> desativarParceiro(UUID parceiroUuid) {
        return null;
    }
}
