package com.cartao.cartao.service;

import com.cartao.cartao.model.Estado;
import com.cartao.cartao.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Page<Estado> listarEstados(Pageable pageable) {
        return estadoRepository.findAll(pageable);
    }
    public Estado inserirEstado(Estado estado) throws Exception {
        for(int i = 0; i < estado.getSigla().length(); i++){
            char sigla = estado.getSigla().charAt(i);
            if(estado.getNome() == null || estado.getSigla() == null || estado.getSigla() == "" || Character.isDigit(sigla)) {
                throw new Exception();
            }
        }
       try {
           return estadoRepository.save(estado);
       }
       catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }

    public Estado alterarEstado(Estado estado) {

        Estado es = estadoRepository.save(estado);
        return es;
    }
}
