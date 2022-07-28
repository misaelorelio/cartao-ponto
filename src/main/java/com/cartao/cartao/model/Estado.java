package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Estado {

    @Id
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="sigla")
    private String sigla;
}
