<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Sentencia necesarias para JDBC -->
<%@ page import="java.sql.Connection"%><%@ page import="java.sql.Statement"%><%@ page import="java.sql.DriverManager"%><%@ page import="java.sql.SQLException"%>
<%
	//1 
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	Connection conexion = null;
	Statement sentencia = null;
	
	
	int filas = 0;
	
	try{
		//2
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaarchitecture", "root", "Agustin-aused4");
		sentencia = conexion.createStatement();
		//3
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
		//4
		filas = sentencia.executeUpdate(consultaSQL);
		response.sendRedirect("ViewBook.jsp");
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