package com.example.crud.parceiro;

import com.example.crud.parceiro.dto.ParceiroRequestDTO;
import com.example.crud.parceiro.dto.ParceiroResponseDTO;
import com.example.crud.parceiro.service.ParceiroService;
import com.example.crud.shared.ApiResponseDTO;
import com.example.crud.shared.MessageResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parceiros")
public class ParceiroController {

    private final ParceiroService service;

    @Operation(
            summary = "Criar parceiro.",
            description = "Registra um parceiro no sistema."
    )
    @PostMapping
    public ResponseEntity<ApiResponseDTO<ParceiroResponseDTO>> cadastroParceiro(@RequestBody @Valid ParceiroRequestDTO parceiroRequestDTO) {
        return service.cadastroParceiro(parceiroRequestDTO);
    }

    @Operation(
            summary = "Atualizar parceiro.",
            description = "Atualiza o registro de um parceiro pelo uuid."
    )
    @PutMapping("/{uuid}")
    public ResponseEntity<MessageResponseDTO> atualizarParceiro(@PathVariable UUID parceiroUuid,
                                                               @RequestBody @Valid ParceiroRequestDTO parceiroRequestDTO) {
        return service.atualizarParceiro(parceiroRequestDTO, parceiroUuid);
    }

    @Operation(
            summary = "Desativar parceiros.",
            description = "Desativa o parceiro do sistema pelo uuid."
    )
    @DeleteMapping("/{uuid}")
    public ResponseEntity<MessageResponseDTO> desativarParceiro(@PathVariable UUID parceiroUuid) {
        return service.desativarParceiro(parceiroUuid);
    }

}
