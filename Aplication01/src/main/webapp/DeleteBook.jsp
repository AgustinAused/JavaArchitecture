<%@page import="com.arquitecturajava.DataBaseException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturajava.Book"%>
<%@ page import="com.arquitecturajava.DataBaseException"%>

<%
try{
	String isbn = request.getParameter("isbn");
	Book book = new Book(isbn);
	book.delete();
	response.sendRedirect("ViewBook.jsp");
	} catch(DataBaseException e){
		%>
		<%=e.getMessage()%>
<%}%>