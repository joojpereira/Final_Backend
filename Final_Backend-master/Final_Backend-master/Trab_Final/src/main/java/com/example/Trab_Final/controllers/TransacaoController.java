package com.example.Trab_Final.controllers;

import com.example.Trab_Final.dto.TransacaoDTO;
import com.example.Trab_Final.models.Transacao;
import com.example.Trab_Final.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity<Page<Transacao>> listar(Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }


    @PostMapping
    public ResponseEntity<Transacao> criar(@RequestBody TransacaoDTO dto) {
        Transacao criada = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}