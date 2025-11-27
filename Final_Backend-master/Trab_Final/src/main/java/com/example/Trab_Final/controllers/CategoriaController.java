package com.example.Trab_Final.controllers;

import com.example.Trab_Final.dto.CategoriaDTO;
import com.example.Trab_Final.models.Categoria;
import com.example.Trab_Final.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<Page<Categoria>> listar(Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody CategoriaDTO dto) {
        Categoria criada = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}