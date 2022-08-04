package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="razao_social")
    private String razaoSocial;
    @Column(name="celular")
    private String celular;
    @Column(name="telefone")
    private String telefone;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    @Column(name="email")
    private String email;
    @Column(name="status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
