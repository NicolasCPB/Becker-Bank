package com.becker.bank.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Compra")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;
    
    private Date dataCompra;
    
    @ManyToOne
    @JoinColumn(name = "identificadorContaUsuario", nullable = false)
    private ContaUsuario contaUsuarioCompra;
}

