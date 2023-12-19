<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="com.arquitecturajava.DataBaseHelper"%>
<%@ page import="com.arquitecturajava.Book"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
	<select name="categoria">
		<option value="seleccionar">seleccionar</option>
		<%
			var listaCategorias = Book.searchAllCategory();
		for(String categoria : listaCategorias){
			%>
				<option value=" <%= categoria %>"><%= categoria %></option>
			<%
		}
		%>
	</select>
	<br />
	
	<%
	var listaDeLibros = Book.searchAll();
	for (Book libro : listaDeLibros) {
	%>
	<%=libro.getIsbn()%>
	<%=libro.getTitulo()%>
	<%=libro.getCategoria()%>
	<a href="DeleteBook.jsp?isbn=<%=libro.getIsbn()%>">Delete</a>
	<br />
	<%
	}
	%>
	<a href="FormInsertBook.jsp">Insert Book</a>
</body>
</html>