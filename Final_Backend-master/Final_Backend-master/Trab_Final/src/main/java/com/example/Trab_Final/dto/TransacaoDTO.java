package com.example.Trab_Final.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public record TransacaoDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        String tipo,
        LocalDate data,
        Long usuarioId,
        Long categoriaId
) {

}