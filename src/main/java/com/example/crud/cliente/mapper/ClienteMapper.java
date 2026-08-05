package com.example.crud.cliente.mapper;

import com.example.crud.cliente.entity.Cliente;
import com.example.crud.cliente.dto.ClienteRequestDTO;
import com.example.crud.cliente.dto.ClienteResponseDTO;
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

        );
    }

    public abstract void updateCliente(
            ClienteRequestDTO dto,
            @MappingTarget Cliente cliente
    );

}
