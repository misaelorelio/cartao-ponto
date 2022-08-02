package com.cartao.cartao.repository;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Page<Endereco> findAll(Pageable pageable);
}

