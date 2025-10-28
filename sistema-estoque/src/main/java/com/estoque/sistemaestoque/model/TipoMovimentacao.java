package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_movimentacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoMovimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descricao; // Ex: "ENTRADA", "SAIDA"

    // Relacionamento One-to-Many com MovimentacaoEstoque
    // MappedBy indica o campo na classe MovimentacaoEstoque que possui a chave estrangeira
    // Usaremos FetchType.LAZY para carregar as movimentações somente quando necessário
    @OneToMany(mappedBy = "tipoMovimentacao", fetch = FetchType.LAZY)
    private java.util.List<MovimentacaoEstoque> movimentacoes;
}
