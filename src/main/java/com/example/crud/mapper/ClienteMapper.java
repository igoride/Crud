package com.example.crud.mapper;

import com.example.crud.dto.request.ClienteRequestDTO;
import com.example.crud.dto.response.ClienteResponseDTO;
import com.example.crud.entity.Cliente;
import com.example.crud.enums.TipoPessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public abstract class ClienteMapper {

    public abstract ClienteResponseDTO toResponse (Cliente cliente);

    public abstract List<ClienteResponseDTO> toResponseList (List<Cliente> clientes);

    public Cliente toEntity (ClienteRequestDTO clienteRequestDTO) {
        return new Cliente(
                clienteRequestDTO.nome(),
                clienteRequestDTO.cpf(),
                clienteRequestDTO.telefone(),
                clienteRequestDTO.telefone(),
                TipoPessoa.FISICA
        );
    }

    public abstract void updateCliente(
            ClienteRequestDTO dto,
            @MappingTarget Cliente cliente
    );

}
