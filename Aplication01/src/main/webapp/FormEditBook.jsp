<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.arquitecturajava.Book"%>

<% Book book = Book.searchForKey(request.getParameter("isbn")); %>

<!DOCTYPE html>
<html>
<head>
<title>Form Edit Book</title>
</head>
<body>
	<form id="editForm" action="EditBook.jsp">
		<fieldset>
			<legend>Formulario Edición Libro</legend>
			<p>
				<label for="isbn">ISBN:</label> <input type="text" id="isbn"
					name="isbn" value="<%=book.getIsbn()%>" required />
			</p>
			<p>
				<label for="titulo">Título:</label> <input type="text" id="titulo"
					name="titulo" value="<%=book.getTitulo() %>" required />
			</p>
			<p>
				<label for="categoria">Categoría:</label> <select name="categoria">
					<%
                    List<String> categoryList = null;
                    categoryList =Book.searchAllCategory();
                    for (String categoria : categoryList) {
                        if (book.getCategoria().equals(categoria)) { %>
					<option value="<%=categoria%>" selected="selected"><%=categoria%></option>
					<%} else { %>
					<option value="<%=categoria%>"><%=categoria%></option>
					<% }
                    } %>
				</select>
			</p>
			<p>
				<input type="submit" value="Save" />
			</p>
		</fieldset>

	</form>

</body>
</html>