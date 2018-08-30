<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Hr Management</title>
</head>
<body>

<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
             <h3 class="w3-bar-item">Menu</h3>
        <a href="hr_dashboard.html" class="w3-bar-item w3-button">Home</a>
        <a href="registration.html" class="w3-bar-item w3-button">REGISTRATION</a>
      <!-- <a href="payrollStatus.html" class="w3-bar-item w3-button">Payroll</a> -->
      <a href="addAnnouncement.html" class="w3-bar-item w3-button">Add Announcement</a>
      <a href="getEmployees.html" class="w3-bar-item w3-button">Employee Details</a>
       <a href="displayLeave.html" class="w3-bar-item w3-button">Leave Approval</a>
       <a href="displaytimesheethr.html" class="w3-bar-item w3-button">Timesheet Approval</a>
       <a href="recruitment.html" class="w3-bar-item w3-button">Add project</a>
       <!-- <a href="recruitedList.html" class="w3-bar-item w3-button">Recruited List</a> -->
       <a href="recruitmentById.html" class="w3-bar-item w3-button">Search project</a>
       <a href="allFeedback.html" class="w3-bar-item w3-button">FeedBacks</a>
       <a href="allComplaint.html" class="w3-bar-item w3-button">Complaints</a>
</div>

        <div style="margin-left:25%">
         <div class="w3-container w3-teal">
               <h1>Welcome ${psno}</h1>
           </div>
<form action = "recruitmentById.html" method="post">
<p>Enter ProjectId:<br> <input type="text" name="projectId"><br>
		<input type="submit" name="submit" value="Submit" />
</form>
<c:choose>
<c:when test="${recruitment.projectId == null}"><h3>No such project</h3></c:when>
<c:when test="${recruitment != null}">
<table border = "1">
<tr>
<th>Project Id</th>
<th>Skills</th>
<th>Experience</th>
</tr>
<tr>
<td>${recruitment.projectId}</td>
<td>${recruitment.skills}</td>
<td>${recruitment.experience}</td>
</tr>
</table>
</c:when>
</c:choose>
</div>
</body>
</html>