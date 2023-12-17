<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
ResultSet rs=null;
try {
	rs=Book.searchAllCategory();
	while(rs.next()) { %>
		<option value="<%=rs.getString("categoria")%>">
			<%=rs.getString("categoria")%></option>
		<% } %>
	</select>
	<br />
	<%
	} catch (SQLException e) {
		System.out.println("Error accediendo a la base de datos" + e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando el resultset" + e.getMessage());
			}
		}
	}
	%>
	<a href="FormInsertBook.jsp">Insertar Libro</a>
</body>
</html>