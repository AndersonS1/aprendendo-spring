package com.javanauta.aprendendo_spring.business;

import com.javanauta.aprendendo_spring.infrastructure.entity.Usuario;
import com.javanauta.aprendendo_spring.infrastructure.exceptions.ConflictException;
import com.javanauta.aprendendo_spring.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.aprendendo_spring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service  // Anotação para indicar que estamos trabalhando com uma Service
@RequiredArgsConstructor  // Anotação para gerar um construtor q somente inicializa os campos q tem o PRIVATE FINAL


public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Método abaixo para salvar o usuário.
    public Usuario salvaUsuario(Usuario usuario) {
        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }
        // Método para verificar se e-mail já existe, caso exista gerar um excessão
        public  void emailExiste(String email){
            try {
                boolean existe = verificaEmailExistente(email);
                if(existe){
                    throw new ConflictException("Email já cadastrado"+ email);
                }
            }catch (ConflictException e){
                throw  new ConflictException("Email já cadastrado", e.getCause());
            }
        }

        public boolean verificaEmailExistente(String email){
            return usuarioRepository.existsByEmail(email);

        }

        public Usuario buscarUsuarioPorEmail(String email){
            return usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email não encontrado" + email));
        }

        public void deletaUsuarioPorEmail(String email){
            usuarioRepository.deleteByEmail(email);
        }

    //existsByEmail(email);
}
