package com.DClothShop.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	
	private String nombre;
	private String categoria;
	private String subcategoria;
	private String genero;
	private String color;
	private double precio;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Producto(int id, String nombre, String categoria, String subcategoria, String genero, String color,
			double precio, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.genero = genero;
		this.color = color;
		this.precio = precio;
		this.url = url;
	}
	public Producto() {
		super();
	}
	
	
	
}
