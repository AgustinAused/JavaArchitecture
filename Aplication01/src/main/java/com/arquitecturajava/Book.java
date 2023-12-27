package com.arquitecturajava;

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
	
	public Book(String isbn) {
		this.isbn = isbn;
	}
	
	public Book() {
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

	public void setTitulo(String title) {
	    this.title = title;
	}
	public String getCategoria() {
		return category;
	}
	public void setCategoria(String category) {
		this.category = category;
	}

	//methods
	public static List<String> searchAllCategory() {
		String consultaSQL = "select distinct categoria from Libros";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> categoryList = helper.seleccionarRegistros(consultaSQL,
		String.class);
		return categoryList;
	}
	
	
	public static List<Book> searchForCategory(String category){
		String consultaSQL = "select isbn,titulo,categoria from Libros where categoria ='" + category + "'";
		DataBaseHelper<Book> helper = new DataBaseHelper<Book>();
		List<Book> bookList = helper.seleccionarRegistros(consultaSQL, Book.class);
		return bookList;
	}
	public void insert(){
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.title + "','" + this.category + "')";
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static List<Book> searchAll() {
		String consultaSQL = "SELECT isbn,titulo,categoria FROM Libros";
		DataBaseHelper<Book>  helper = new DataBaseHelper<Book>();
		var bookList = helper.seleccionarRegistros(consultaSQL,Book.class);
		return bookList;
	}
	
	public static Book findByIsbn(String isbn) {
		String consulta = "select isbn,titulo,categoria from Libros where isbn =" + isbn + "";
		DataBaseHelper<Book>  helper = new DataBaseHelper<Book>();
		var bookList = helper.seleccionarRegistros(consulta,Book.class);
		return bookList.get(0);
		
	}
	
	public void delete(){
		String consultaSQL = "delete from Libros where isbn='" + this.isbn + "'";
		DataBaseHelper<Book>  helper = new DataBaseHelper<Book>();
		helper.modificarRegistro(consultaSQL);
		
	}
	
	public void save(){
		String consultaSQL = "update Libros set titulo='" + this.title + "', categoria='" + this.category + "' where isbn='" + this.isbn + "'";
		System.out.println(consultaSQL);
		DataBaseHelper<Book>  helper = new DataBaseHelper<Book>();
		helper.modificarRegistro(consultaSQL);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", category=" + category + "]";
	}
	
	
}
