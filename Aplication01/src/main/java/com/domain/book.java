package com.domain;

import com.arquitecturajava.DataBaseHelper;
import java.sql.ResultSet;


public class book {
	
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