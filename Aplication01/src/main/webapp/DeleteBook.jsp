<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturajava.Book" %>

<%
	String isbn = request.getParameter("isbn");
	Book book = new Book(isbn);
	book.delete();
	response.sendRedirect("ViewBook.jsp");
	
%>