package com.example.crud.cliente.service;

import com.example.crud.shared.MessageResponseDTO;
import com.example.crud.cliente.entity.Cliente;
import com.example.crud.cliente.mapper.ClienteMapper;
import com.example.crud.cliente.repository.ClienteRepository;
import com.example.crud.cliente.specification.ClienteSpecification;
import com.example.crud.cliente.dto.ClienteFilterDTO;
import com.example.crud.cliente.dto.ClienteRequestDTO;
import com.example.crud.cliente.dto.ClienteResponseDTO;
import com.example.crud.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
