package com.DClothShop.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DClothShop.store.model.Usuario;

public interface IUsuarioRepo  extends JpaRepository<Usuario, Integer>{

	@Query(nativeQuery = true, value = "select * from Usuario  where nombre=:nombre and password=:pwd")
	Optional<Usuario> findByNamePwd(@Param("nombre")String nombre,@Param("pwd")String pwd);
	
}
