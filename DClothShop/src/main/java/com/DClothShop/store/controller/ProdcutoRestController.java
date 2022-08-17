package com.DClothShop.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DClothShop.store.model.Producto;
import com.DClothShop.store.service.IProductoService;

@RestController
@RequestMapping("/api/product")
public class ProdcutoRestController {

	@Autowired
	private IProductoService iProductoService;
	
	@PostMapping("/save")
	public Producto guardaProd(@RequestBody Producto prod) {
		
		try {
			iProductoService.creaProduct(prod);
		}catch(Exception e) {
			prod.setNombre("Error " + e);
		}
		
		return prod;
	}
	
	@PostMapping("/listPr")
	public List<Producto> listaProd (@RequestBody Producto prod){
		return iProductoService.listarProds();
	}
	
}
