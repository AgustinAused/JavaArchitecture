package com.javaArchitecture.controller.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {
	public abstract String execute(HttpServletRequest req, HttpServletResponse res);
}
