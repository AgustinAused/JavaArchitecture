<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Sentencia necesarias para JDBC -->
//%@ page import="com.arquitecturajava.DataBaseHelper" %>
<%@ page import="com.arquitecturajava.Book"%>


<%
	//1 
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	//realizo la consulta usando el DBHelper y el codigo queda simplificado
	try{
	Book book = new Book(isbn,titulo,categoria);
	book.insert();
	} catch(Exception e){
		%>
		<%= e.getMessage() %>
		<%
	}
	response.sendRedirect("ViewBook.jsp");
	
	
%>