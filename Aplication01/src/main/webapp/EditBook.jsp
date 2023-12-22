<%@page import="com.arquitecturajava.DataBaseException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturajava.Book"%>

<%	
try{	
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	//create a Book
	Book book = new Book(isbn,titulo,categoria);
	//save a edit book
	book.save();
	//redirect
	response.sendRedirect("ViewBook.jsp");
} catch(DataBaseException e){
	%>
	<%=e.getMessage()%>
<%}%>