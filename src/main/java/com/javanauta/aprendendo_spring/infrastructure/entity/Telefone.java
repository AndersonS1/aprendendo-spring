package com.javanauta.aprendendo_spring.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // para apontar que essa classe é uma tabela
@Table(name="telefones")  // anotação para indicar o nome da tabela

public class Telefone {
    // na criação da tabela, as anotações @Id, @GeneratedValue(strategy = GenerationType.IDENTITY) e private long id; - SÃO PADRÃO.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para gerar automaticamente os ID

    private Long id;

    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;
    }

