package com.example.Trab_Final.services;

import com.example.Trab_Final.Enum.TipoTransacao;
import com.example.Trab_Final.dto.TransacaoDTO;
import com.example.Trab_Final.exception.InvalidDataException;
import com.example.Trab_Final.exception.ResourceNotFoundException;
import com.example.Trab_Final.models.Transacao;
import com.example.Trab_Final.repositories.CategoriaRepository;
import com.example.Trab_Final.repositories.TransacaoRepository;
import com.example.Trab_Final.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    public Page<Transacao> listar(Pageable pageable) {
        return transacaoRepo.findAll(pageable);
    }

    public Transacao buscarPorId(Long id) {
        return transacaoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transação com ID " + id + " não encontrada."));
    }

    public Transacao salvar(TransacaoDTO dto) {
        if (dto.valor() == null || dto.valor().doubleValue() <= 0) {
            throw new InvalidDataException("O valor da transação deve ser maior que zero.");
        }

        Transacao t = new Transacao();
        t.setDescricao(dto.descricao());
        t.setValor(dto.valor());
        t.setTipo(TipoTransacao.valueOf(dto.tipo()));
        t.setData(dto.data());
        t.setUsuario(usuarioRepo.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + dto.usuarioId() + " não encontrado.")));
        t.setCategoria(categoriaRepo.findById(dto.categoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com ID " + dto.categoriaId() + " não encontrada.")));

        return transacaoRepo.save(t);
    }


    public void deletar(Long id) {
        if (!transacaoRepo.existsById(id)) {
            throw new ResourceNotFoundException("Transação com ID " + id + " não encontrada para exclusão.");
        }
        transacaoRepo.deleteById(id);
    }
}