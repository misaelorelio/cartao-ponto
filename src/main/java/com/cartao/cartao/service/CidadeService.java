package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Estado;
import com.cartao.cartao.repository.CidadeRepository;
import com.cartao.cartao.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Page<Cidade> listarCidades(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public Cidade salvarCidade(Cidade cidade) throws Exception {
        try {
            List<Estado> estados = estadoRepository.findAll();

                if (cidade == null || estados.isEmpty()) {
                    throw new Exception();
                }

                return cidadeRepository.save(cidade);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Cidade alterarCidade(Cidade cidade) throws Exception {
        try {
            List<Estado> estados = estadoRepository.findAll();

            if (cidade == null || estados.isEmpty()) {
                throw new Exception();
            }
            return cidadeRepository.save(cidade);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
