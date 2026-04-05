package com.javanauta.aprendendo_spring.infrastructure.repository;


// Toda entidade(TABELA) é obrigatório a criação do Repository, independente se a tabela tem relação ou não.

import com.javanauta.aprendendo_spring.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

// Na crição desta classe ela veio assim - public class UsuarioRepository
// Precisamos trocar para - public interface UsuarioRepository extends JpaRepository <>
// neste momento ela está herdando e não implementando, pois podemos usar-lá ou não.

@Repository // Anotação para o Sprig identificar que este é um repositório.
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
