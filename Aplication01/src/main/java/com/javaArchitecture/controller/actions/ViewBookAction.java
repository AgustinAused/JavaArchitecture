package com.javaArchitecture.controller.actions;

import java.util.List;

import com.javaArchitecture.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewBookAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		List<Book> listaDeLibros = null;
		String selectdISBN = req.getParameter("selectedCategory");
		System.out.println("existe selectedCtegory : ");
		System.out.println(req.getParameter("selectedCategory"));

		if (req.getParameter("selectedCategory") == null
				|| req.getParameter("selectedCategory").equals("seleccionar")) {
			listaDeLibros = Book.searchAll();
		} else {
			listaDeLibros = Book.searchForCategory(selectdISBN);
		}
		System.out.println(listaDeLibros.isEmpty());
		List<String> listaDeCategorias = Book.searchAllCategory();
		System.out.println(listaDeCategorias.isEmpty());
		req.setAttribute("listaDeLibros", listaDeLibros);
		req.setAttribute("listaDeCategorias", listaDeCategorias);
		return "/ViewBook.jsp";
	}

}
