package com.DClothShop.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DClothShop.store.model.Producto;
import com.DClothShop.store.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo iProductoRepo;
	
	public Producto creaProduct(Producto prod) {
		return iProductoRepo.save(prod);
	}
	
	public List<Producto> listarProds(){
		return iProductoRepo.findAll();
	}
	
	public void borraPrd(Producto prod) {
		iProductoRepo.delete(prod);
	}
	
	public Optional<Producto> buscaProd(int id){
		return iProductoRepo.findById(id);
	}
}
