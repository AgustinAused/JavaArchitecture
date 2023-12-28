package com.arquitecturajava;

import java.io.IOException;
import java.util.List;

import com.arquitecturajava.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//omitimos imports
@WebServlet("/ControladorLibros")
public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher despachador = null;
		List<Book> listaDeLibros = Book.searchAll();
		List<String> listaDeCategorias = Book.searchAllCategory();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		despachador = request.getRequestDispatcher("ViewBook.jsp");
		despachador.forward(request, response);
	}
}
