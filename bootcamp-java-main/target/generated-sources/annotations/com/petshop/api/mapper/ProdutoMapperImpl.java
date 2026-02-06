package com.petshop.api.mapper;

import com.petshop.api.dto.ProdutoRequestDTO;
import com.petshop.api.dto.ProdutoResponseDTO;
import com.petshop.api.model.Produto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoResponseDTO toResponseDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        Double preco = null;

        id = produto.getId();
        nome = produto.getNome();
        preco = produto.getPreco();

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO( id, nome, preco );

        return produtoResponseDTO;
    }

    @Override
    public Produto toEntity(ProdutoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setNome( dto.nome() );
        produto.setPreco( dto.preco() );

        return produto;
    }

    @Override
    public void updateEntityFromDto(ProdutoRequestDTO dto, Produto entity) {
        if ( dto == null ) {
            return;
        }

        entity.setNome( dto.nome() );
        entity.setPreco( dto.preco() );
    }
}
