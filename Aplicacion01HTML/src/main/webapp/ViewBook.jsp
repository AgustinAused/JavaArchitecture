<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
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
	Connection conexion = null;
	Statement sentencia = null;
	ResultSet rs = null;
	
	try{
		//1
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaarchitecture", "root", "Agustin-aused4");
		sentencia = conexion.createStatement();
		
		//2 
		String ConsultaSQL = "SELECT isbn,titulo,categoria from Libros";
		
		//3,4
		rs = sentencia.executeQuery(ConsultaSQL);
		//5
		while(rs.next()){%>
			<%=rs.getString("isbn") %> | 
			<%=rs.getString("titulo") %> | 
			<%=rs.getString("categoria") %>
			<br/>	
		<%}
	} catch(ClassNotFoundException e){
		System.out.print("Error en la carga del driver" + e.getMessage());
		
	} catch(SQLException e){
		System.out.println("Error accediendo a la base de datos : " + e.getMessage());
		
	}finally{
		
		//5
		if(sentencia != null){
			try{sentencia.close();}
			catch(SQLException e){System.out.print("Error cerrando la sentecia " + e.getMessage());}
		}
		if (conexion != null){
			try{conexion.close();}
			catch(SQLException e){System.out.print("Eroor cerrando la conexion  "+ e.getMessage());}
		}
	}
	
%>
<a href="FormInsertBook.jsp">Insertar Libro</a>
</body>
</html>