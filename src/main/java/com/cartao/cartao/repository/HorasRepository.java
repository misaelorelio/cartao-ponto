package com.cartao.cartao.repository;

import com.cartao.cartao.model.Colaborador;
import com.cartao.cartao.model.Horas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasRepository extends JpaRepository<Horas, Integer> {

    @Query(value = "select h from Horas h where h.status = true")
    Page<Horas> listarHoras(Pageable pageable);
}
