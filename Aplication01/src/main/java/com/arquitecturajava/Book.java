package com.arquitecturajava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


	public static List<String> searchAllCategory() {
		String consultaSQL = "select distint(categoria) from Libros";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> categoryList = helper.seleccionarRegistros(consultaSQL,
		String.class);
		return categoryList;
	}
	public void insert() {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.title + "','" + this.category + "')";
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static List<Book> searchAll() {
		String consultaSQL = "select isbn,titulo,categoria from Libros";
		DataBaseHelper<Book>  helper = new DataBaseHelper<Book>();
		var bookList = helper.seleccionarRegistros(consultaSQL,Book.class);
		
		return bookList;
	}
	
	public void delete() {
		String consultaSQL = "delete from Libros where isbn='" + this.isbn + "'";
		DataBaseHelper<Book>  helper = new DataBaseHelper<Book>();
		helper.modificarRegistro(consultaSQL);
		
	}
}
