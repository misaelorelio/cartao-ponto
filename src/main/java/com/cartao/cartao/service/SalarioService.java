package com.cartao.cartao.service;

import com.cartao.cartao.model.Salario;
import com.cartao.cartao.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalarioService {

    @Autowired
    private SalarioRepository salarioRepository;


    public Page<Salario> listarSalario(Pageable pageable) {
        return salarioRepository.findAll(pageable);
    }

    public Salario salvarSalario(Salario salario) throws Exception {
        try {
                if (salario == null ) {
                    throw new Exception();
                }

                return salarioRepository.save(salario);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Salario alterarSalario(Salario salario) throws Exception {
        try {

            if (salario == null) {
                throw new Exception();
            }
            return salarioRepository.save(salario);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
