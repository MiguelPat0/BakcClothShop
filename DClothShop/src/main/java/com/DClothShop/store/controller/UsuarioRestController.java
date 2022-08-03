package com.DClothShop.store.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DClothShop.store.model.Usuario;
import com.DClothShop.store.service.IUsuarioService;

@RestController
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService iUsuarioService;

	@PostMapping("/aerouertos/buscar")
	public Usuario loguear(@RequestBody Usuario user)  throws Exception {
		Optional<Usuario> us = Optional.ofNullable(new Usuario());
		us=iUsuarioService.buscarUsuario(user.getId());
		
		if (!us.isEmpty()) {
			user=us.get();
		}else {
			user.setId(0);
		}
		
		return user;
	}
}
