package com.cartao.cartao.repository;

import com.cartao.cartao.model.Colaborador;
import com.cartao.cartao.model.Horas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HorasRepository extends JpaRepository<Horas, Integer> {

    @Query(value = "select h from Horas h where h.status = true")
    Page<Horas> listarHoras(Pageable pageable);

    @Query(value = "select h from Horas h where h.id =?1")
    Horas ultimoRegistro(Integer id);

    @Query(value = "select d from Horas d where d.horaRegistrada >?1 and d.colaborador.id = ?2 order by 'asc'")
    List<Horas> findByHoraRegistradaAndColaborador_Id(LocalDateTime data, Integer id);

}
