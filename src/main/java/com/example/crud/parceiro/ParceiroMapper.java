package com.example.crud.parceiro;

import com.example.crud.parceiro.dto.ParceiroRequestDTO;
import com.example.crud.parceiro.dto.ParceiroResponseDTO;
import com.example.crud.parceiro.entity.Parceiro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public abstract class ParceiroMapper {

    public abstract ParceiroResponseDTO toResponse(Parceiro parceiro);

    public abstract List<ParceiroResponseDTO> toResponseList(List<Parceiro> parceiros);

    public Parceiro toEntity(ParceiroRequestDTO parceiroRequestDTO) {
        return new Parceiro(
                parceiroRequestDTO.nome(),
                parceiroRequestDTO.email(),
                parceiroRequestDTO.cpfCnpj(),
                parceiroRequestDTO.tipoPessoa()
        );
    }

    public abstract void updateEntity(
            ParceiroRequestDTO dto,
            @MappingTarget Parceiro parceiro
    );

}
