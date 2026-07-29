package com.example.crud.service.impl;

import com.example.crud.dto.MessageResponseDTO;
import com.example.crud.dto.filter.ClienteFilterDTO;
import com.example.crud.dto.request.ClienteRequestDTO;
import com.example.crud.dto.response.ClienteResponseDTO;
import com.example.crud.entity.Cliente;
import com.example.crud.exception.NotFoundException;
import com.example.crud.mapper.ClienteMapper;
import com.example.crud.repository.ClienteRepository;
import com.example.crud.service.ClienteService;
import com.example.crud.specification.ClienteSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Override
    public Page<ClienteResponseDTO> buscaTodos(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Override
    public ResponseEntity<Page<ClienteResponseDTO>> buscarClientes(ClienteFilterDTO filterDTO, Pageable pageable) {
        Page<ClienteResponseDTO> clientes = repository.findAll(ClienteSpecification.filter(filterDTO),
                pageable).map(mapper::toResponse);

        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<MessageResponseDTO> criarCliente(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = mapper.toEntity(clienteRequestDTO);
        repository.save(cliente);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessageResponseDTO("Cliente criado com sucesso."));
    }

    @Override
    public ResponseEntity<MessageResponseDTO> atualizarCliente(ClienteRequestDTO clienteRequestDTO, Long id) {
        Cliente clienteAtualizado = repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
        mapper.updateCliente(clienteRequestDTO, clienteAtualizado);
        repository.save(clienteAtualizado);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessageResponseDTO("Cliente atualizado com sucesso."));
    }

    @Override
    public ResponseEntity<MessageResponseDTO> desativarCliente(Long id) {
        Cliente clienteDesativado = repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
        clienteDesativado.setAtivo(false);
        repository.save(clienteDesativado);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessageResponseDTO("Cliente desativado com sucesso."));
    }

}
