<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.arquitecturajava.Book"%>

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
</head>
<body>
	<form action="ViewBook" method="get">
		<select name="selectedCategory">
			<option value="seleccionar">seleccionar</option>
			<%
			for (String categoria : listaDeCategorias) {
				if (categoria.equals(request.getParameter("selectedCategory"))) {
			%>
			<option value="<%=categoria%>" selected><%=categoria%></option>
			<%
			} else {
			%>
			<option value="<%=categoria%>"><%=categoria%></option>
			<%
			}
			}
			%>
		</select> <input type="submit" value="Filtrar">
	</form>
	<br />

	<%
	for (Book libro : listaDeLibros) {
	%>
	<%=libro.getIsbn()%>
	<%=libro.getTitulo()%>
	<%=libro.getCategoria()%>
	<a href="DeleteBook?isbn=<%=libro.getIsbn()%>">Borrar</a>

	<a href="FormEditBook?isbn=<%=libro.getIsbn()%>">Editar</a>

	<br />
	<%
	}
	%>

	<a href="FormInsertBook">Insertar Libro</a>

</body>
</html>