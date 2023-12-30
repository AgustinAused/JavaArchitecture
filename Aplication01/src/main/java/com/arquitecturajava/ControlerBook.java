package com.arquitecturajava;

<<<<<<< HEAD
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
			List<Book> listaDeLibros = Book.searchAll();
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
		} else {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			var libro = new Book(isbn, titulo, categoria);
			libro.insert();
			despachador = request.getRequestDispatcher("/ControlerBook/ViewBook");

		}
		despachador.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

=======
		List<Book> listaDeLibros = Book.searchAll();
		List<String> listaDeCategorias = Book.searchAllCategory();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		despachador = request.getRequestDispatcher("ViewBook.jsp");
		despachador.forward(request, response);
	}
>>>>>>> 32a8373 (Refactored the ViewBook.jsp JSP file, applying the Single Responsibility Principle (SRP))
}
