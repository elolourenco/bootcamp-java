package com.petshop.api.controller;

import com.petshop.api.dto.ProdutoRequestDTO;
import com.petshop.api.dto.ProdutoResponseDTO;
import com.petshop.api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor // Isso injeta o service automaticamente
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController() {
        service = null;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(@RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
