package com.becker.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becker.bank.dto.UsuarioDTO;
import com.becker.bank.exception.BusinessException;
import com.becker.bank.model.Usuario;
import com.becker.bank.repository.UsuarioRepository;
import com.becker.bank.utils.ObjectUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
		findByCpf(usuarioDTO.cpf()).ifPresent(usuario -> {
	        throw new BusinessException("Usuário com este CPF já cadastrado.");
	    });
		
		
		Usuario usuario = ObjectUtils.convert(usuarioDTO, Usuario.class);
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> findByCpf(String cpf) {
		return usuarioRepository.findByCpf(cpf);
	}
}
