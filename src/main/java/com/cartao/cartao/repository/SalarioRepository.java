package com.cartao.cartao.repository;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Salario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Integer> {

    Page<Salario> findAll(Pageable pageable);
}
