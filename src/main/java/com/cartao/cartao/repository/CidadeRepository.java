package com.cartao.cartao.repository;

import com.cartao.cartao.model.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    Page<Cidade> findAll(Pageable pageable);

}
