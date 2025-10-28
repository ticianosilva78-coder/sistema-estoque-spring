package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fornecedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String cnpj;

    private String telefone;

    // Relacionamento One-to-Many com Produto
    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private java.util.List<Produto> produtos;
}
