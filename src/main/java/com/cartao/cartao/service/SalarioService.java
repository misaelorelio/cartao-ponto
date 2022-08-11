package com.cartao.cartao.service;

import com.cartao.cartao.model.Horas;
import com.cartao.cartao.model.Salario;
import com.cartao.cartao.repository.HorasRepository;
import com.cartao.cartao.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalarioService {

    @Autowired
    private SalarioRepository salarioRepository;

    @Autowired
    private HorasRepository horasRepository;


    public Page<Salario> listarSalario(Pageable pageable) {
        return salarioRepository.findAll(pageable);
    }

    public Salario salvarSalario(Salario salario) throws Exception {
        //Essa lógica ainda não esta certa
        LocalDate dataInicial = LocalDate.of(2022,8,01);
        LocalDate dataFinal =  LocalDate.of(2022,8,10);
        List<Horas> horas = horasRepository.findByDataRegistroBetweenAndColaborador_Id(dataInicial, dataFinal, 3);
        for (Horas h: horas) {
            h.getHoraRegistrada();
        }
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
