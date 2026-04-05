package com.javanauta.aprendendo_spring.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // para apontar que essa classe é uma tabela
@Table(name="usuario")  // anotação para indicar o nome da tabela

public class Usuario { //implements UserDetails
    // na criação da tabela, as anotações @Id, @GeneratedValue(strategy = GenerationType.IDENTITY) e private long id; - SÃO PADRÃO.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para gerar automaticamente os ID

    private Long id;
    @Column(name = "nome", length = 100) // Anotação Collum, serve para definir o nome da coluna no DB
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL) // Anotação - OneToMany (Um usuário para muitos endereços)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> endereco;  // Para criar e apontar para a tabela Endereço.

    @OneToMany(cascade = CascadeType.ALL) // Anotação - OneToMany (Um usuário para muitos endereços)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;  // Para criar e apontar para a tabela Telefone.


    //@Override
    public @Nullable String getPassword() {
        return senha;
    }

    //@Override
    public String getUsername() {
        return email;
    }
}
