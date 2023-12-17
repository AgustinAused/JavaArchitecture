package com.arquitecturajava;

import java.sql.ResultSet;

public class Book {

	private String isbn;
	private String title;
	private String category;
	
	//Constructor
	public Book(String isbn, String title,String category) {
		this.isbn = isbn;
		this.title = title;
		this.category = category;
	}
	
	//Getters and Setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return title;
	}
	public void setTitulo(String tilte) {
		this.title = tilte;
	}
	public String getCategoria() {
		return category;
	}
	public void setCategoria(String category) {
		this.category = category;
	}


	public static ResultSet searchAllCategory() {
		String consultaSQL = "select distinct(categoria) from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		return rs;
	}
	public static void insert() {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + isbn + "','" + title + "','" + this.category + "')";
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
