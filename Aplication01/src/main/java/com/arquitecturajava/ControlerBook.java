package com.arquitecturajava;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//omitimos imports
@WebServlet("/ControlerBook")
public class ControlerBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		if(request.getServletPath().equals("/ViewBook.do")) {
			List<Book> listaDeLibros = Book.searchAll();
			System.out.println(listaDeLibros.isEmpty());
			List<String> listaDeCategorias = Book.searchAllCategory();
			System.out.println(listaDeCategorias.isEmpty());
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			despachador = request.getRequestDispatcher("ViewBook.jsp");	
		}else if (request.getServletPath().equals("/FormInsertBook.do")) {
			List<String> listaDeCategorias=null;
			listaDeCategorias = Book.searchAllCategory();
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			despachador = request.getRequestDispatcher("FormInsertBook.jsp");
		}else{
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			var libro = new Book(isbn, titulo, categoria);
			libro.insert();
			despachador = request.getRequestDispatcher("ViewBook.do");
			
		}
		despachador.forward(request, response);
	}
}
