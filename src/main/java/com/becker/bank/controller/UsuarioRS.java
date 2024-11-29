package com.becker.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.becker.bank.dto.UsuarioDTO;
import com.becker.bank.model.Usuario;
import com.becker.bank.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario", produces = "application/json")
public class UsuarioRS {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public HttpEntity<Usuario> cadastrarUsuario(@RequestBody @Validated @Valid UsuarioDTO usuarioDTO) {
		return new ResponseEntity<Usuario>(usuarioService.cadastrarUsuario(usuarioDTO), HttpStatus.CREATED);
	}
}
