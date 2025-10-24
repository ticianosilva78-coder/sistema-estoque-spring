package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes_estoque")
@Data

public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now(); // Data e hora do registro

    @Column(nullable = false)
    private Integer quantidade;

    // Mapeia o ENUM como String no banco de dados para clareza
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoMovimentacao tipo;

    // Relacionamento ManyToOne com Produto
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    // Relacionamento ManyToOne com Usuário (quem realizou a movimentação)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
