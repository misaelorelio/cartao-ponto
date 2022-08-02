package com.cartao.cartao.repository;

import com.cartao.cartao.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    public Page<Estado> findAll(Pageable pageable);
}
