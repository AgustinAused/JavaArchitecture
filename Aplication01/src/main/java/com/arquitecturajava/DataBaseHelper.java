package com.arquitecturajava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DataBaseHelper {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
 	private static final String URL = "jdbc:mysql://localhost:3306/javaarchitecture"; // System.getenv("URL");
	private static final String USER = "root"; //System.getenv("USER");
	private static final String PASSWORD = "Agustin-aused4"; //System.getenv("PASSWORDDB") 
	
	
	public DataBaseHelper() {
		System.out.println("URL: " + URL);
        System.out.println("USER: " + USER);
        System.out.println("PASSWORD: " + PASSWORD);
	}
	
	
	public int modificarRegistro(String consultaSQL) {
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
		} catch (ClassNotFoundException e) {
			System.out.print("Error en la carga del driver" + e.getMessage());

		} catch (SQLException e) {
			System.out.println("Error accediendo a la base de datos : " + e.getMessage());

		} finally {

			// 5
			if (sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
					System.out.print("Error cerrando la sentecia " + e.getMessage());
				}
			}
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					System.out.print("Eroor cerrando la conexion  " + e.getMessage());
				}
			}
		}
		return filasAfectadas;
	}

	public ResultSet seleccionarRegistros(String consultaSQL) {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
			return filas;
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("Error Driver" + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Error de SQL " + e.getMessage());
		}
		return filas;
	}

}
