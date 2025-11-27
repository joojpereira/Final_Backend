package com.example.Trab_Final.services;

import com.example.Trab_Final.dto.UsuarioDTO;
import com.example.Trab_Final.exception.InvalidDataException;
import com.example.Trab_Final.exception.ResourceNotFoundException;
import com.example.Trab_Final.models.Usuario;
import com.example.Trab_Final.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Page<Usuario> listar(Pageable pageable) {
        return usuarioRepo.findAll(pageable);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado."));
    }

    public Usuario salvar(UsuarioDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new InvalidDataException("O nome do usuário é obrigatório.");
        }
        if (dto.email() == null || !dto.email().contains("@")) {
            throw new InvalidDataException("E-mail inválido.");
        }

        Usuario u = new Usuario();
        u.setNome(dto.nome());
        u.setEmail(dto.email());
        u.setSenha(dto.senha());
        return usuarioRepo.save(u);
    }

    public Usuario atualizar(Long id, UsuarioDTO dto) {
        Usuario u = usuarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado."));

        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new InvalidDataException("O nome do usuário não pode ser vazio.");
        }

        u.setNome(dto.nome());
        u.setEmail(dto.email());
        u.setSenha(dto.senha());
        return usuarioRepo.save(u);
    }

    public void deletar(Long id) {
        if (!usuarioRepo.existsById(id)) {
            throw new ResourceNotFoundException("Usuário com ID " + id + " não encontrado para exclusão.");
        }
        usuarioRepo.deleteById(id);
    }
}