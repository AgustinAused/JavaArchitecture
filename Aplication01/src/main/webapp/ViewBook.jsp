<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.arquitecturajava.Book"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!@SuppressWarnings("unchecked")%>

<%
List<Book> listaDeLibros = (List<Book>) request.getAttribute("listaDeLibros");
List<String> listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
	text-align: center;
}

form {
	margin-bottom: 20px;
}

select {
	padding: 8px;
}

input[type="submit"] {
	padding: 8px 12px;
	background-color: #4caf50;
	color: white;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.book-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
}

.book-card {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 20px;
	margin: 10px;
	width: 300px;
}

.book-actions {
	margin-top: 10px;
	display: flex;
	justify-content: space-between;
}

a {
	text-decoration: none;
	color: #333;
}

.insert-link {
	display: block;
	margin-top: 20px;
	font-size: 18px;
}
</style>
</head>
<body>
	<form action="ViewBook" method="get">
    <select name="selectedCategory">
        <option value="seleccionar">Seleccionar</option>
        <c:forEach var="categoria" items="${listaDeCategorias}">
            <option value="${categoria}">${categoria}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Filtrar">
</form>
	<div class="book-container">
		<%
		for (Book libro : listaDeLibros) {
		%>
		<div class="book-card">
			<p>
				<strong>ISBN:</strong>
				<%=libro.getIsbn()%></p>
			<p>
				<strong>Título:</strong>
				<%=libro.getTitulo()%></p>
			<p>
				<strong>Categoría:</strong>
				<%=libro.getCategoria()%></p>
			<div class="book-actions">
				<a href="DeleteBook?isbn=<%=libro.getIsbn()%>">Borrar</a> <a
					href="FormEditBook?isbn=<%=libro.getIsbn()%>">Editar</a>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<a href="FormInsertBook" class="insert-link">Insertar Libro</a>
</body>
</html>