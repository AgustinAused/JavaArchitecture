package com.javaArchitecture.controller.actions;

import com.javaArchitecture.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertBookAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		String titulo = req.getParameter("titulo");
		String categoria = req.getParameter("categoria");
		var libro = new Book(isbn, titulo, categoria);
		libro.insert();
		return "/ControlerBook/ViewBook";
	}

}
