package com.DClothShop.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DClothShop.store.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
