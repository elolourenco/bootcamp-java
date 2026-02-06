package com.petshop.api.service.impl;
import com.petshop.api.dto.ProdutoRequestDTO;
import com.petshop.api.dto.ProdutoResponseDTO;
import com.petshop.api.mapper.ProdutoMapper;
import com.petshop.api.model.Produto;
import com.petshop.api.repository.ProdutoRepository;
import com.petshop.api.service.ProdutoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoServiceImpl(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // REMOVIDO: O construtor manual que estava causando o erro de "already defined"

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    @Override
    @Transactional
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        Produto produto = mapper.toEntity(dto);
        Produto salvo = repository.save(produto);
        return mapper.toResponseDTO(salvo);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produtoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));

        mapper.updateEntityFromDto(dto, produtoExistente);

        return mapper.toResponseDTO(repository.save(produtoExistente));
    }

    @Override
    @Transactional
    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir: Produto não encontrado");
        }
        repository.deleteById(id);
    }
}