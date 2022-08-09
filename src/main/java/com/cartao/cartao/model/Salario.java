package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Salario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="inss")
    private Double inss;
    @Column(name="valor_horas")
    private Double valorHoras;
    @Column(name="quantidade_horas_mes")
    private Double qtdHorasMes;
    @Column(name="salario_liquido")
    private Double salarioLiquido;
    @Column(name="salario_bruto")
    private Double salarioBruto;
    @Column(name="fgts")
    private Double fgts;
    @Column(name="qtd_horas_falta_mes")
    private Double qtdHorasFaltaMes;
    @Column(name="qtd_horas_extra_mes")
    private Double qtdHorasExtraMes;
    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;
}
