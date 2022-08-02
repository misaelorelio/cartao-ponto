package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="cep")
    private String cep;
    @Column(name="numero")
    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
