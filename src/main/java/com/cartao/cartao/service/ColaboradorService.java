package com.cartao.cartao.service;

import com.cartao.cartao.model.Colaborador;
import com.cartao.cartao.model.Empresa;
import com.cartao.cartao.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Page<Colaborador> listarColaborador(Pageable pageable) {
        return colaboradorRepository.listarColaboradores(pageable);
    }

    public Colaborador inserirColaborador(Colaborador colaborador) throws Exception {
        if(colaborador.getNome() != null) {
            return colaboradorRepository.save(colaborador);
        }else {
            throw new Exception();
        }
    }

    public Colaborador atualizarColaborador(Colaborador colaborador) throws Exception {
        if(colaborador.getId() == null) {
            throw new Exception();
        }

        return colaboradorRepository.save(colaborador);
    }
}
