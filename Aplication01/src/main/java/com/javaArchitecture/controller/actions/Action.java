package com.javaArchitecture.controller.actions;

import java.lang.reflect.InvocationTargetException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {
	public abstract String execute(HttpServletRequest req, HttpServletResponse res);

	public static Action getAction(String tipo) {
		Action action = null;
		// Dividir la cadena por "/"
		String[] partes = tipo.split("/");
		// Tomar la última parte de la matriz resultante
		String nombreAccion = partes[partes.length - 1];
		try {
			// Obtener el nombre del paquete de la clase Action
			String packageName = Action.class.getPackageName();
			// Construir el nombre completo de la clase que se va a instanciar
			String className = packageName + "." + nombreAccion + "Action";
			// Utilizar la reflexión para crear una nueva instancia de la clase
			Class<?> clazz = Class.forName(className);
			action = (Action) clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException |
		         NoSuchMethodException | InvocationTargetException e) {
		    e.printStackTrace();
		}
		return action;
	}
}
