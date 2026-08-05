package com.example.crud.cliente.service;

import com.example.crud.shared.MessageResponseDTO;
import com.example.crud.cliente.dto.ClienteFilterDTO;
import com.example.crud.cliente.dto.ClienteRequestDTO;
import com.example.crud.cliente.dto.ClienteResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ClienteService {

    ResponseEntity<Page<ClienteResponseDTO>> buscarClientes(ClienteFilterDTO filterDTO, Pageable pageable);

    ResponseEntity<MessageResponseDTO> criarCliente(ClienteRequestDTO clienteRequestDTO);

    ResponseEntity<MessageResponseDTO> atualizarCliente(ClienteRequestDTO clienteRequestDTO, Long id);

    ResponseEntity<MessageResponseDTO> desativarCliente(Long id);

    Page<ClienteResponseDTO> buscaTodos(Pageable pageable);
}
