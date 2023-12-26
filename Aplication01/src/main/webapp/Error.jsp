<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>

    <h2>An error occurred:</h2>
    <p>Error details: <%= exception.getMessage() %></p>
	<p>Error Interno:<%=exception.getCause().getMessage()%> </p>
</body>
</html>