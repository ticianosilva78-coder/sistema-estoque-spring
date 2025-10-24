package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false)
    private Integer quantidade = 0; // Estoque atual

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco; // Tipo para valores monetários

    @Column(nullable = false)
    private Integer estoqueMinimo = 0;

    // Relacionamento ManyToOne: Muitos Produtos pertencem a UM Fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false) // Coluna da chave estrangeira no BD
    private Fornecedor fornecedor;

}
