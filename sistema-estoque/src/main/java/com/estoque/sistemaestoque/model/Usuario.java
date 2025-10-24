package com.estoque.sistemaestoque.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id // Define como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento do PostgreSQL
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String senha; // Será hasheada em um sistema seguro

    @Column(nullable = false, length = 50)
    private String role; // Ex: ADMIN, USER

}
