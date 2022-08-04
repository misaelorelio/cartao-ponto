package com.cartao.cartao.repository;

import com.cartao.cartao.model.Colaborador;
import com.cartao.cartao.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query(value = "select c from Colaborador c where c.status = true")
    Page<Colaborador> listarColaboradores(Pageable pageable);
}
