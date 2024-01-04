package com.javaArchitecture.controller.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {
	public abstract String execute(HttpServletRequest req, HttpServletResponse res);
	public static Action getAction(String tipo) {
		Action action = null;
		if (tipo.equals("/ControlerBook/ViewBook")) {
			action = new ViewBookAction();
		} else if (tipo.equals("/ControlerBook/FormInsertBook")) {
			action = new FormInsertBookAction();
		} else if (tipo.equals("/ControlerBook/InsertBook")) {
			action = new InsertBookAction();
		} else if (tipo.equals("/ControlerBook/FormEditBook")) {
			action = new FormEditBookAction();
		} else if (tipo.equals("/ControlerBook/DeleteBook")) {
			action = new DeleteBookAction();
		} else if (tipo.equals("/ControlerBook/SaveBook")) {
			action = new SaveAction();
		}
		return action;
	}
}
