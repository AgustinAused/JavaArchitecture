package com.arquitecturajava;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ControlerBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher despachador = null;
		System.out.println(request.getServletPath());

		if (request.getServletPath().equals("/ControlerBook/ViewBook")) {
			List<Book> listaDeLibros = null;
			String selectdISBN = request.getParameter("selectedCategory");
			System.out.println("existe selectedCtegory : ");
			System.out.println(request.getParameter("selectedCategory"));

			if(request.getParameter("selectedCategory") == null || request.getParameter("selectedCategory").equals("seleccionar")) {
				listaDeLibros = Book.searchAll();				
			}else {
				listaDeLibros = Book.searchForCategory(selectdISBN);
			}
			System.out.println(listaDeLibros.isEmpty());
			List<String> listaDeCategorias = Book.searchAllCategory();
			System.out.println(listaDeCategorias.isEmpty());
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			despachador = request.getRequestDispatcher("/ViewBook.jsp");
		} else if (request.getServletPath().equals("/ControlerBook/FormInsertBook")) {
			List<String> listaDeCategorias = null;
			listaDeCategorias = Book.searchAllCategory();
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			despachador = request.getRequestDispatcher("/FormInsertBook.jsp");
		} else if (request.getServletPath().equals("/ControlerBook/InsertBook")) {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			var libro = new Book(isbn, titulo, categoria);
			libro.insert();
			despachador = request.getRequestDispatcher("/ControlerBook/ViewBook");
		} else if (request.getServletPath().equals("/ControlerBook/FormEditBook")) {
			String isbn = request.getParameter("isbn");
			List<String> listaDeCategorias = Book.searchAllCategory();
			Book book = Book.findByIsbn(isbn);
			request.setAttribute("libro", book);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			despachador = request.getRequestDispatcher("/FormEditBook.jsp");
		} else if(request.getServletPath().equals("/ControlerBook/DeleteBook")) {
			String isbn = request.getParameter("isbn");
			var book = new Book(isbn);
			book.delete();
			despachador = request.getRequestDispatcher("/ControlerBook/ViewBook");
		}else if(request.getServletPath().equals("/ControlerBook/SaveBook")) {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			var libro = new Book(isbn, titulo, categoria);
			libro.save();
			despachador = request.getRequestDispatcher("/ControlerBook/ViewBook");
			
		}
		despachador.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
