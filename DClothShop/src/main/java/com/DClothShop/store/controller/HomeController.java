package com.DClothShop.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.DClothShop.store.model.Producto;
import com.DClothShop.store.service.IProductoService;
import com.DClothShop.store.service.UploadService;


@Controller
public class HomeController {
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private UploadService upload;
	
	@GetMapping("/")
	public String goHome(Model model) {
		
		List<Producto> listProd =iProductoService.listarProds();
		model.addAttribute("titulo", "Bienvenido a D'ClothShop");
		model.addAttribute("listProd", listProd);
		Producto prd = new Producto();
		model.addAttribute("producto", prd);
		return "inicio";
	}
	
	@GetMapping("/up")
	public String goUp(Model model) {
		
		
		return "cargaAr";
	}
	
	@PostMapping("/cargar")
	public String carga( @RequestParam("archivos") MultipartFile file, RedirectAttributes ms,Model model, Producto prod) {
		try {
		upload.save(file);
		ms.addFlashAttribute("mensaje", "Archivo guardado correctamente!!");
		iProductoService.creaProduct(prod);
		}catch(Exception e) {
			
		}
		List<Producto> listProd =iProductoService.listarProds();
		model.addAttribute("titulo", "Bienvenido a D'ClothShop");
		model.addAttribute("listProd", listProd);
		Producto prd = new Producto();
		model.addAttribute("producto", prd);
		return "inicio";
	}

}
