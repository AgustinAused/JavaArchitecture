package com.javaArchitecture.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.javaArchitecture.Book;
import com.javaArchitecture.controller.actions.*;

public class ControlerBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher despachador = null;
		System.out.println(request.getServletPath());
		Action action = null;
		if (request.getServletPath().equals("/ControlerBook/ViewBook")) {
			action = new ViewBookAction();
		} else if (request.getServletPath().equals("/ControlerBook/FormInsertBook")) {
			action = new FormInsertBookAction();
		} else if (request.getServletPath().equals("/ControlerBook/InsertBook")) {
			action = new InsertBookAction();
		} else if (request.getServletPath().equals("/ControlerBook/FormEditBook")) {
			action = new FormEditBookAction();
		} else if (request.getServletPath().equals("/ControlerBook/DeleteBook")) {
			action = new DeleteBookAction();
		} else if (request.getServletPath().equals("/ControlerBook/SaveBook")) {
			action = new SaveAction();
		}
		despachador = request.getRequestDispatcher(action.execute(request, response));
		despachador.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
