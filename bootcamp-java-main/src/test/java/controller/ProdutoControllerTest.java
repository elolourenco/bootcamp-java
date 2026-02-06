package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petshop.api.controller.ProdutoController;
import com.petshop.api.dto.ProdutoRequestDTO;
import com.petshop.api.dto.ProdutoResponseDTO;
import com.petshop.api.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProdutoController.class) // Carrega apenas a camada web
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Cria um Mock do Service para o Spring usar no Controller
    private ProdutoService service;

    @Autowired
    private ObjectMapper objectMapper; // Converte objetos para JSON

    private ProdutoResponseDTO responseDTO;
    private ProdutoRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        responseDTO = new ProdutoResponseDTO(1L, "Ração", 50.0);
        requestDTO = new ProdutoRequestDTO("Ração", 50.0);
    }

    @Test
    @DisplayName("GET /produtos - Deve retornar lista e status 200")
    void deveListarProdutos() throws Exception {
        when(service.listar()).thenReturn(List.of(responseDTO));

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Ração"))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    @DisplayName("POST /produtos - Deve criar produto e retornar status 200")
    void deveSalvarProduto() throws Exception {
        when(service.salvar(any(ProdutoRequestDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Ração"));
    }

    @Test
    @DisplayName("PUT /produtos/{id} - Deve atualizar e retornar status 200")
    void deveAtualizarProduto() throws Exception {
        when(service.atualizar(eq(1L), any(ProdutoRequestDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(put("/produtos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("DELETE /produtos/{id} - Deve retornar status 204")
    void deveRemoverProduto() throws Exception {
        mockMvc.perform(delete("/produtos/1"))
                .andExpect(status().isNoContent());
    }
}