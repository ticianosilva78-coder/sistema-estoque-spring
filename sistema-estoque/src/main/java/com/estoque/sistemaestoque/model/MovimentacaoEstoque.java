package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes_estoque")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    // Relacionamento Many-to-One com Produto
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    // Relacionamento Many-to-One com TipoMovimentacao
    @ManyToOne
    @JoinColumn(name = "tipo_movimentacao_id", nullable = false)
    private TipoMovimentacao tipoMovimentacao;

    // Relacionamento Many-to-One com Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    }


