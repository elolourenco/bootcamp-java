package com.petshop.api.mapper;

import com.petshop.api.dto.ProdutoRequestDTO;
import com.petshop.api.dto.ProdutoResponseDTO;
import com.petshop.api.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoResponseDTO toResponseDTO(Produto produto);

    Produto toEntity(ProdutoRequestDTO dto);

    void updateEntityFromDto(ProdutoRequestDTO dto, @MappingTarget Produto entity);
}
