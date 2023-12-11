<%@page import="com.arquitecturajava.DataBaseHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
<%
	//1
	ResultSet rs = null;		
	//2 
	
	//3,4
	try{
		
		String ConsultaSQL = "SELECT isbn,titulo,categoria from Libros";
		DataBaseHelper db = new DataBaseHelper();
		rs = db.selecionarRegistros(ConsultaSQL);
		//5
		while(rs.next())%>
			{ <%=rs.getString("isbn") %> | <%=rs.getString("titulo") %> | <%=rs.getString("categoria") %> }
			<br/>	
		<%
		
		
	}catch (SQLException e) {
		System.out.println("Error accediendo a la base de datos"
				+ e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando el resultset"
				+ e.getMessage());
			}
		}
	}
%>
<a href="FormInsertBook.jsp">Insertar Libro</a>
</body>
</html>