package com.DClothShop.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DClothShop.store.model.Usuario;



public interface IUsuarioRepo  extends JpaRepository<Usuario, Integer>{

}
