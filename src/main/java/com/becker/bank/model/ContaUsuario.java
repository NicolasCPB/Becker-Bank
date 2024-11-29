package com.becker.bank.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ContaUsuario")
@Data
public class ContaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    @OneToOne
    @JoinColumn(name = "identificadorUsuario", unique = true)
    private Usuario usuario;

    private Date dataCriacao; 

    private Date dataDesativacao;

    private BigDecimal saldo;

    @OneToMany(mappedBy = "contaUsuarioCompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Compra> compras;

    private BigDecimal creditoDisponivel;
}
