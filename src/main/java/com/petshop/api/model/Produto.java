package com.petshop.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Garante que o nome não seja nulo no banco
    private String nome;

    @Column(nullable = false)
    private Double preco;
}