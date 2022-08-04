package com.cartao.cartao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Colaborador {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="email")
    private String email;
    @Column(name="data_cadastro_empresa")
    private LocalDate dataCadastroEmpresa;
    @Column(name="status")
    private Boolean status;
    @Column(name="cpf")
    private String cpf;
    @Column(name="data_entrada_sistema_ponto")
    private LocalDate dataEntradaSistemaPonto;
    @Column(name="identidade")
    private String identidade;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
