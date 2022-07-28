package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cidade {

    @Id
    private Integer id;
    @Column(name="nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
}
