package com.DClothShop.store.service;

import java.util.List;
import java.util.Optional;

import com.DClothShop.store.model.Producto;

public interface IProductoService {

	public Producto creaProduct(Producto prod);
	
	public List<Producto> listarProds();
	
	public void borraPrd(Producto prod) ;
	
	public Optional<Producto> buscaProd(int id);
	
}
