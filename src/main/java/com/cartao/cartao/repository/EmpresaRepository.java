package com.cartao.cartao.repository;

import com.cartao.cartao.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Query(value = "select e from Empresa e where e.status = true")
    Page<Empresa> listarEmpresas(Pageable pageable);
}
