package com.arquitecturajava;

import java.sql.ResultSet;

public class Book {

	private String isbn;
	private String titulo;
	private String categoria;
	
	//Constructor
	
	//Getters and Setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public static ResultSet searchAllCategory() {
		String consultaSQL = "select distinct(categoria) from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		return rs;
	}
	public static void insert(String isbn, String titulo, String categoria) {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static ResultSet searchAll() {
		String consultaSQL = "select isbn,titulo,categoria from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		return rs;
		}
}
