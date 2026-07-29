package com.example.crud.service;

import com.example.crud.dto.MessageResponseDTO;
import com.example.crud.dto.filter.ClienteFilterDTO;
import com.example.crud.dto.request.ClienteRequestDTO;
import com.example.crud.dto.response.ClienteResponseDTO;
import com.example.crud.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    ResponseEntity<Page<ClienteResponseDTO>> buscarClientes(ClienteFilterDTO filterDTO, Pageable pageable);

    ResponseEntity<MessageResponseDTO> criarCliente(ClienteRequestDTO clienteRequestDTO);

    ResponseEntity<MessageResponseDTO> atualizarCliente(ClienteRequestDTO clienteRequestDTO, Long id);

    ResponseEntity<MessageResponseDTO> desativarCliente(Long id);

    Page<ClienteResponseDTO> buscaTodos(Pageable pageable);
}
