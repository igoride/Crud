package com.example.crud.controller;

import com.example.crud.dto.MessageResponseDTO;
import com.example.crud.dto.filter.ClienteFilterDTO;
import com.example.crud.dto.request.ClienteRequestDTO;
import com.example.crud.dto.response.ClienteResponseDTO;
import com.example.crud.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Clientes",
        description = "Endpoints responsáveis pelo gerenciamento de clientes."
)
@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @Operation(
            summary = "Listar clientes.",
            description = "Retorna uma lista de todos os clientes."
    )
    @GetMapping("/all")
    public Page<ClienteResponseDTO> buscaTodos(@PageableDefault(
                                                    page = 0, size = 20, sort = "nome"
                                               ) Pageable pageable) {
        return service.buscaTodos(pageable);
    }

    @Operation(
            summary = "Filtro de clientes.",
            description = "Filtra clientes por nome, cpf, email e ativo com filtro like."
    )
    @GetMapping("/filtro")
    public ResponseEntity<Page<ClienteResponseDTO>> filtro(ClienteFilterDTO filtro,
                                                           @PageableDefault(
                                                                   page = 0, size = 20, sort = "nome"
                                                           ) Pageable pageable) {
        return service.buscarClientes(filtro,pageable);
    }

    @Operation(
            summary = "Criar cliente.",
            description = "Registra um cliente no sistema."
    )
    @PostMapping
    public ResponseEntity<MessageResponseDTO> criarCliente(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
        return service.criarCliente(clienteRequestDTO);
    }

    @Operation(
            summary = "Atualizar cliente.",
            description = "Atualiza o registro de um cliente pelo id."
    )
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> atualizarCliente(@PathVariable Long id,
                                                               @RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
        return service.atualizarCliente(clienteRequestDTO, id);
    }

    @Operation(
            summary = "Desativar clientes.",
            description = "Desativa o cliente do sistema pelo id."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDTO> desativarCliente(@PathVariable Long id) {
        return service.desativarCliente(id);
    }
}
