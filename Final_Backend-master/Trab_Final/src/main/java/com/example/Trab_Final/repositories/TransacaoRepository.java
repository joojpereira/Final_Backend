package com.example.Trab_Final.repositories;


import com.example.Trab_Final.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface TransacaoRepository extends JpaRepository<Transacao, Long>, JpaSpecificationExecutor<Transacao> {

}