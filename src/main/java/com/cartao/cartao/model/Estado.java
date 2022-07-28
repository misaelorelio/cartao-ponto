package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="sigla")
    private String sigla;
}
