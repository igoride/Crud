package com.example.crud.parceiro.service;

import com.example.crud.cliente.service.ClienteService;
import com.example.crud.exception.ConflictException;
import com.example.crud.exception.NotFoundException;
import com.example.crud.parceiro.mapper.ParceiroMapper;
import com.example.crud.parceiro.dto.ParceiroRequestDTO;
import com.example.crud.parceiro.dto.ParceiroResponseDTO;
import com.example.crud.parceiro.entity.Parceiro;
import com.example.crud.parceiro.repository.ParceiroRepository;
import com.example.crud.shared.ApiResponseDTO;
import com.example.crud.shared.MessageResponseDTO;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ParceiroServiceImpl implements ParceiroService {

    private final ParceiroRepository parceiroRepository;
    private final ParceiroMapper parceiroMapper;

    @Transactional
    @Override
    public ResponseEntity<ApiResponseDTO<ParceiroResponseDTO>> cadastroParceiro(ParceiroRequestDTO parceiroRequestDTO) {
        if (parceiroRepository.existsByCpfCnpj(parceiroRequestDTO.cpfCnpj())) {
            throw new ConflictException("Cpf/Cnpj já cadastrado no sistema.");
        }

        Parceiro parceiro = parceiroMapper.toEntity(parceiroRequestDTO);
        parceiroRepository.save(parceiro);

        ApiResponseDTO<ParceiroResponseDTO> response = ApiResponseDTO.of(
                "Parceiro criado com Sucesso.",
                parceiroMapper.toResponse(parceiro)
        );

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{uuid}")
                .buildAndExpand(parceiro.getUuid())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @Transactional
    @Override
    public ResponseEntity<MessageResponseDTO> atualizarParceiro(ParceiroRequestDTO parceiroRequestDTO, UUID parceiroUuid) {
        Parceiro parceiro = buscarPorUuid(parceiroUuid);

        parceiro.setNome(parceiroRequestDTO.nome());
        parceiro.setEmail(parceiroRequestDTO.email());

        parceiroRepository.save(parceiro);
        return ResponseEntity.ok(new MessageResponseDTO("Parceiro atualizado."));
    }

    @Transactional
    public ResponseEntity<MessageResponseDTO> ativarParceiro(UUID parceiroUuid) {
        Parceiro parceiro = buscarPorUuid(parceiroUuid);
        parceiro.setAtivo(true);

        return ResponseEntity.ok(new MessageResponseDTO("Parceiro ativado."));
    }

    @Transactional
    @Override
    public ResponseEntity<MessageResponseDTO> desativarParceiro(UUID parceiroUuid) {
        Parceiro parceiro = buscarPorUuid(parceiroUuid);
        parceiro.setAtivo(false);

        return ResponseEntity.ok(new MessageResponseDTO("Parceiro desativado."));
    }

    public Parceiro buscarPorUuid (UUID parceiroUuid) {
        return parceiroRepository.findByUuid(parceiroUuid)
                .orElseThrow(() -> new NotFoundException("Parceiro não encontrado."));
    }
}
