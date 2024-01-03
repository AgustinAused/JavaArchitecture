<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaArchitecture.Book"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%!@SuppressWarnings("unchecked")%>

<%
List<String> listaDeCategorias = null;
listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias");
var libro = (Book) request.getAttribute("libro");
%>

<!DOCTYPE html>
<html>
<head>
<title>Form Edit Book</title>
<style>
<
style>body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

form {
	max-width: 600px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
}

h2 {
	text-align: center;
	color: #333;
}

fieldset {
	border: 1px solid #ddd;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
}

label {
	display: block;
	margin-bottom: 8px;
}

input[type="text"], select {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</style>
</head>
<body>

	<form id="editForm"
		action="<%=request.getContextPath()%>/ControlerBook/SaveBook"
		method="get">
		<h2>Formulario Edición Libro</h2>
		<p>
			<label for="isbn">ISBN:</label> <input type="text" id="isbn"
				name="isbn" value="${libro.getIsbn()}" required readonly />
		</p>
		<p>
			<label for="titulo">Título:</label> <input type="text" id="titulo"
				name="titulo" value="${libro.getTitulo()}" required />
		</p>
		<p>
			<label for="categoria">Categoría:</label> <select name="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<c:choose>
						<c:when test="${libro.categoria eq categoria}">
							<option value="${categoria}" selected="selected">${categoria}</option>
						</c:when>
						<c:otherwise>
							<option value="${categoria}">${categoria}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" value="Save" />
		</p>
	</form>
</body>
</html>