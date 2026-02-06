package service;

import com.petshop.api.dto.ProdutoResponseDTO;
import com.petshop.api.mapper.ProdutoMapper;
import com.petshop.api.model.Produto;
import com.petshop.api.repository.ProdutoRepository;
import com.petshop.api.service.impl.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    // Inicializa o Mockito

        @Mock
        private ProdutoRepository repository;

        @Mock
        private ProdutoMapper mapper;

        @InjectMocks
        private ProdutoServiceImpl service; // Injeta os mocks acima nesta classe

        private Produto produto;
        private ProdutoResponseDTO responseDTO;

        @BeforeEach
        void setUp() {
            // Inicializa dados de teste comuns
            produto = new Produto(1L, "Ração", 50.0);
            responseDTO = new ProdutoResponseDTO(1L, "Ração", 50.0);
        }
}





