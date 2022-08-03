package com.DClothShop.store.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DClothShop.store.model.Usuario;
import com.DClothShop.store.service.IUsuarioService;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;
	
	@PostMapping("/save")
	public Usuario Listaru(@RequestBody Usuario user){
		Usuario us = new Usuario();
		
		try {
		us= iUsuarioService.create(user);
		}catch(Exception e) {
			us.setNombre("Error: " + e );
		}	
		return us;				
	}	
	
	@RequestMapping("/ListUser")
	public List<Usuario> ListaUsuario(){
		List<Usuario> ListUs = null ;
		try {
			ListUs=iUsuarioService.listarUsuarios();
		}catch(Exception e) {
			Usuario us=new Usuario();
			us.setNombre("Error:" + e);
			ListUs.add(us);
		}
		
		return ListUs;
	}
	
	
}
