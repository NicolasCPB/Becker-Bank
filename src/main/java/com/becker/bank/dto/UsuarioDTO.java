package com.becker.bank.dto;

import com.becker.bank.anotacoes.Cpf;
import com.becker.bank.anotacoes.Senha;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
	
	@NotNull(message = "Campo obrigatório - nome")
	String nome, 
	
	@Cpf
	@NotNull(message = "Campo obrigatório - cpf")
	String cpf, 
	
	@Email
	@NotNull(message = "Campo obrigatório - email")
	String email,
	
	@NotNull(message = "Campo obrigatório - dataNascimento")
	String dataNascimento,
	
	@NotNull(message = "Campo obrigatório - senha")
	@Senha
	String senha
	)
{}
