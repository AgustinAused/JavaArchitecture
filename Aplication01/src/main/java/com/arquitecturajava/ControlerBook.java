package com.arquitecturajava;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControlerBook extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
		RequestDispatcher dispacher = null;
		List<Book> bookList = Book.searchAll();
		List<String> categoryList = Book.searchAllCategory();
		req.setAttribute("listaCategoria", categoryList);
		req.setAttribute("listaLibros", bookList);
		dispacher = req.getRequestDispatcher("ViewBook.jsp");
		dispacher.forward(req, res);
		
		
		
	}

}
