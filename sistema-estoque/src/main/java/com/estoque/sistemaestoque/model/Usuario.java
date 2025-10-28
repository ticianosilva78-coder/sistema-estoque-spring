package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; // Em um sistema real, use criptografia!

    @Column(nullable = false)
    private String role; // Ex: ADMIN, ESTOQUISTA, etc.

    // Relacionamento One-to-Many com MovimentacaoEstoque
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private java.util.List<MovimentacaoEstoque> movimentacoes;

}
