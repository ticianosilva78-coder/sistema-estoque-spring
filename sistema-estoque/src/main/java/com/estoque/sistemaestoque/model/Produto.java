package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    // Campo para o controle de estoque
    @Column(nullable = false)
    private Integer quantidadeEstoque = 0; // Inicializa com 0

    // Relacionamento Many-to-One com Fornecedor (Chave Estrangeira)
    @ManyToOne(fetch = FetchType.EAGER) // EAGER para carregar o fornecedor junto com o produto
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    // Relacionamento One-to-Many com MovimentacaoEstoque
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private java.util.List<MovimentacaoEstoque> movimentacoes;

}
