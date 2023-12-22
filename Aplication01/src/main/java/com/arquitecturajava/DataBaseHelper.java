package com.arquitecturajava;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class DataBaseHelper<T> {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/javaarchitecture"; // System.getenv("URL");
	private static final String USER = "root"; // System.getenv("USER");
	private static final String PASSWORD = "Agustin-aused4"; // System.getenv("PASSWORDDB")

	public DataBaseHelper() {
//		System.out.println("URL: " + URL);
//		System.out.println("USER: " + USER);
//		System.out.println("PASSWORD: " + PASSWORD);
	}

	public int modificarRegistro(String consultaSQL) throws DataBaseException {
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada" + e.getMessage());
			throw new DataBaseException("Clase no encontrada");
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage());
			throw new DataBaseException("Error de SQL",e);
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

	public List<T> seleccionarRegistros(String consultaSQL, Class<T> clase) {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos = new ArrayList<T>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
			while (filas.next()) {
				T objeto = clase.getDeclaredConstructor().newInstance();
				Method[] metodos = objeto.getClass().getDeclaredMethods();
				for (int i = 0; i < metodos.length; i++) {
					if (metodos[i].getName().startsWith("set")) {
						metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
					}
					if (objeto.getClass().getName().equals("java.lang.String")) {
						objeto = extracted(filas);
					}
				}
				listaDeObjetos.add(objeto);
			}
		} catch (Exception e) {
			System.out.println("Error al seleccionar registros" + e.getMessage());
		} finally {
			if (sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
				}
			}
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
				}
			}
		}
		return listaDeObjetos;

	}

	private T extracted(ResultSet filas) throws SQLException {
		return (T) filas.getString(1);
	}
}
