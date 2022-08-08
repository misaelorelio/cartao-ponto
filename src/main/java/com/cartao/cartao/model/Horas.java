package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
public class Horas {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="data_registro")
    private LocalDate dataRegistro;
    @Column(name="tipo")
    private Boolean tipo;
    @Column(name="justificativa")
    private String justificativa;
    @Column(name="horas_registrada")
    private String horaRegistrada;
    @Column(name="status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

}
