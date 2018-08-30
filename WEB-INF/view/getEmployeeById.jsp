<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
               <h1>Welcome </h1>
           </div>
<form action = "getEmployeeById.html" method="post">
<p>Enter Psno:<br> <input type="text" name="psno" placeholder="psno"><br><br>
		<input type="submit" name="submit" value="Submit" />
</form>
<c:choose>
<c:when test="${employee.firstName == null}"><h3>No employee found</h3></c:when>
<c:when test="${employee != null}">
<table border = "1">
<tr>
<th>Employee P.S. Number</th>
<th>First Name</th>
<th>Middle Name</th>
<th>Last Name</th>
<th>Date of Birth</th>
<th>Date of Joining</th>
<th>Address</th>
<th>Phone Number</th>
<th>10th Percentage</th>
<th>10th Board</th>
<th>12th/Diploma Percentage</th>
<th>12th/Diploma Percentage/University</th>
<th>Graduation Percentage</th>
<th>Degree</th>
<th>Branch</th>
<th>Project Id</th>
<th>Skills</th>
</tr>
<tr>
<td>${employee.psno}</td>
<td>${employee.firstName}</td>
<td>${employee.middleName}</td>
<td>${employee.lastName}</td>
<td>${employee.dob}</td>
<td>${employee.doj}</td>
<td>${employee.address}</td>
<td>${employee.phoneno}</td>
<td>${employee.percent10}</td>
<td>${employee.board10}</td>
<td>${employee.percent12}</td>
<td>${employee.board12}</td>
<td>${employee.percentGrad}</td>
<td>${employee.degree}</td>
<td>${employee.branch}</td>
<td>${employee.projectId}</td>
<td>${employee.skills}</td>
</tr>
</table>
</c:when>
</c:choose>
</div>
</body>
</html>