<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<%
response.setHeader("cache-control","no-cache,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp");
}


%>
	Welcome ${username} ...
	<a href="videos.jsp"> Click For Video</a>
	
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>