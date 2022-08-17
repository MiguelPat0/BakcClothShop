package com.DClothShop.store.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.DClothShop.store.model.Usuario;
import com.DClothShop.store.repository.IUsuarioRepo;
import com.DClothShop.store.service.IUsuarioService;



@RestController
public class UsuarioRestController {
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@PostMapping("/pagos/nPago")
	public List<Usuario> getHome(@RequestBody Usuario us) {
		
		System.out.println("entro");
		List<Usuario> ListUs = null ;
		try {
			ListUs=iUsuarioService.listarUsuarios();
		}catch(Exception e) {
			Usuario us1=new Usuario();
			us1.setNombre("Error:" + e);
			ListUs.add(us1);
		}
		
		return ListUs;
	}
	
	@PostMapping("/login/usuario")
	public Usuario getUsu(@RequestBody Usuario us) {
		
		System.out.println("entro"+ us.getNombre());
		
		try {
			Optional<Usuario> usop = null;
			usop=iUsuarioService.buscaUser(us);
			if(usop.isEmpty()) {
				us.setId(0);
				us.setNombre("Usuario o contraseña incorrectos");
			}else {
				us=usop.get();
			}
		}catch(Exception e) {
			
			us.setNombre("Error:" + e);
			
		}
		
		return us;
	}

}
