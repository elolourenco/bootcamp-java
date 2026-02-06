package com.petshop.api.service;

import com.petshop.api.dto.ProdutoRequestDTO;
import com.petshop.api.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {
    List<ProdutoResponseDTO> listar();
    ProdutoResponseDTO buscarPorId(Long id);
    ProdutoResponseDTO salvar(ProdutoRequestDTO dto);
    ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto);
    void remover(Long id);
}