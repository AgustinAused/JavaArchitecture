<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Sentencia necesarias para JDBC -->
<%@ page import="com.arquitecturajava.DataBaseHelper" %>
<%
	//1 
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
	consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
	
	//2: realizo consulta con db helper 
	
	DataBaseHelper db = new DataBaseHelper();
	int filas = db.modificarRegistro(consultaSQL);
	response.sendRedirect("ViewBook.jsp");
	
	
%>