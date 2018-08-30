<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Successful</h4>
		Hello ${userName}!<br>
		<%-- <%
			out.println("Hello " + session.getAttribute("userName") + "!");
		%> --%>
		<h5><a href = "logout.html">Log out</a></h5>
		
	<a href="payrollStatus.html">Payroll Details</a>
	
	<a href="profile.html">Display Profile</a>
</body>
</html>