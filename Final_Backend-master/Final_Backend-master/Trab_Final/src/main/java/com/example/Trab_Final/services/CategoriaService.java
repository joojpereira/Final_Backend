package com.example.Trab_Final.services;

import com.example.Trab_Final.dto.CategoriaDTO;
import com.example.Trab_Final.exception.InvalidDataException;
import com.example.Trab_Final.exception.ResourceNotFoundException;
import com.example.Trab_Final.models.Categoria;
import com.example.Trab_Final.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    public Page<Categoria> listar(Pageable pageable) {
        return categoriaRepo.findAll(pageable);
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com ID " + id + " não encontrada."));
    }

    public Categoria salvar(CategoriaDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new InvalidDataException("O nome da categoria é obrigatório.");
        }
        Categoria c = new Categoria();
        c.setNome(dto.nome());
        return categoriaRepo.save(c);
    }

    public Categoria atualizar(Long id, CategoriaDTO dto) {
        Categoria c = categoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com ID " + id + " não encontrada."));


        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new InvalidDataException("O nome da categoria não pode ser vazio.");
        }

        c.setNome(dto.nome());
        return categoriaRepo.save(c);
    }

    public void deletar(Long id) {
        if (!categoriaRepo.existsById(id)) {
            throw new ResourceNotFoundException("Categoria com ID " + id + " não encontrada para exclusão.");
        }
        categoriaRepo.deleteById(id);
    }
}