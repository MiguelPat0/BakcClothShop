package com.DClothShop.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DClothShop.store.model.Usuario;
import com.DClothShop.store.repository.IUsuarioRepo;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	
	public Usuario create(Usuario usuario) {
		return iUsuarioRepo.save(usuario);
	}
	
	public List<Usuario> listarUsuarios(){
		return iUsuarioRepo.findAll();
	}
	
	public void deleteUsuario(Usuario usuario) {
		iUsuarioRepo.delete(usuario);
	}
	
	public Optional<Usuario> buscarUsuario(int id){
		return iUsuarioRepo.findById(id);
	}
	
}
