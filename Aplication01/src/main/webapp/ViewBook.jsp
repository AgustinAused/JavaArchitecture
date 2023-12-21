<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.arquitecturajava.DataBaseHelper"%>
<%@ page import="com.arquitecturajava.Book"%>
<%@ page import="java.util.List"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
	<form action="ViewBook.jsp" method="get">
    <select name="categoria">
        <option value="seleccionar">seleccionar</option>
        <% var listaCategorias = Book.searchAllCategory();
        for (String categoria : listaCategorias) { %>
            <option value="<%=categoria%>"><%=categoria%></option>
        <% } %>
    </select>
    <button type="submit">Filter</button>
</form>

	<%
	List<Book> listaDeLibros = null;
	if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
		listaDeLibros = Book.searchAll();
	} else {
		listaDeLibros = Book.searchForCategory(request.getParameter("categoria"));
	}
	for (Book libro : listaDeLibros) {
	%>

	<%=libro.getIsbn()%>
	|
	<%=libro.getTitulo()%>
	|
	<%=libro.getCategoria()%>
	<a href="DeleteBook.jsp?isbn=<%=libro.getIsbn()%>">Delete</a>
	<a href="FormEditBook.jsp?isbn=<%=libro.getIsbn()%>">Edit</a>
	<br />

	<%
	}
	%>

	<a href="FormInsertBook.jsp">Insert Book</a>
</body>
</html>