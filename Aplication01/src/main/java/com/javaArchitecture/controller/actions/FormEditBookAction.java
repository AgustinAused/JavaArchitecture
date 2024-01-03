package com.javaArchitecture.controller.actions;

import java.util.List;

import com.javaArchitecture.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormEditBookAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		List<String> listaDeCategorias = Book.searchAllCategory();
		Book book = Book.findByIsbn(isbn);
		req.setAttribute("libro", book);
		req.setAttribute("listaDeCategorias", listaDeCategorias);
		return "/FormEditBook.jsp";
	}

}
