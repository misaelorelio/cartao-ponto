package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Estado;
import com.cartao.cartao.repository.CidadeRepository;
import com.cartao.cartao.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Page<Cidade> listaCidades(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public Cidade inserirCidade(@RequestBody Cidade cidade) throws Exception {
        try {
            List<Estado> estados = estadoRepository.findAll();
            for (Estado in: estados) {
                in.getId();
                if (cidade == null || estados.isEmpty() || cidade.getEstado().getId() != in.getId()) {
                    throw new Exception();
                }
            }

                return cidadeRepository.save(cidade);

        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
