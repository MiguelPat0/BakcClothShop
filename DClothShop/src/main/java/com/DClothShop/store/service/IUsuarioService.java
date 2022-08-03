package com.DClothShop.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DClothShop.store.model.Usuario;



@Service
public interface IUsuarioService {

	public Usuario create(Usuario usuario);
	
	public List<Usuario> listarUsuarios();
	
	public void deleteUsuario(Usuario usuario);
	
	public Optional<Usuario> buscarUsuario(int id);
	
}
