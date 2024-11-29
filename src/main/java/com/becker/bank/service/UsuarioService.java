package com.becker.bank.service;

import com.becker.bank.dto.UsuarioDTO;
import com.becker.bank.model.Usuario;

public interface UsuarioService {

	public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO);
}
