package com.cartao.cartao.service;

import com.cartao.cartao.model.Empresa;
import com.cartao.cartao.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    LocalDate localDate = LocalDate.now();
    public Page<Empresa> listarEmpresas(Pageable pageable) {
        return empresaRepository.listarEmpresas(pageable);
    }

    public Empresa inserirEmpresa(Empresa empresa) throws Exception {
        if(empresa.getCelular() != null
                && empresa.getNome() != null && empresa.getEndereco() !=null
                && empresa.getRazaoSocial() != null) {
            empresa.setDataCadastro(localDate);
            return empresaRepository.save(empresa);
        }else {
            throw new Exception();
        }
    }

    public Empresa atualizarEmpresa(Empresa empresa) throws Exception {
        if(empresa.getId() == null) {
            throw new Exception();
        }

        empresa.setDataCadastro(localDate);
        return empresaRepository.save(empresa);
    }
}
