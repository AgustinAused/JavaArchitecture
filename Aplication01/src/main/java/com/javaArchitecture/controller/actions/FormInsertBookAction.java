package com.javaArchitecture.controller.actions;

import java.util.List;

import com.javaArchitecture.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormInsertBookAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		List<String> listaDeCategorias = null;
		listaDeCategorias = Book.searchAllCategory();
		req.setAttribute("listaDeCategorias", listaDeCategorias);
		return "/FormInsertBook.jsp";
	}

}
