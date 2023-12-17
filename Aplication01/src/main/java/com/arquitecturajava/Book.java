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
		String consultaSQL = "select distinct(categoria) from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		var categogyList = new ArrayList<String>();
		String categoria = null;
		try {
			while(rs.next()) {
				categoria = rs.getString("categoria");
				categogyList.add(categoria);
			}			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categogyList;
	}
	public void insert() {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.title + "','" + this.category + "')";
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static List<Book> searchAll() {
		String consultaSQL = "select isbn,titulo,categoria from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		var bookList = new ArrayList<Book>();
		try {
			while(rs.next()) {
				bookList.add(new Book(rs.getString("isbn"),
						rs.getString("titulo"),
						rs.getString("categoria")));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return bookList;
		}
}
