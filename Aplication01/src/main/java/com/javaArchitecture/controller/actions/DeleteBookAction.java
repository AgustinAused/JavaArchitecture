package com.javaArchitecture.controller.actions;

import com.javaArchitecture.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBookAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		var book = new Book(isbn);
		book.delete();
		return "/ControlerBook/ViewBook";
	}

}
