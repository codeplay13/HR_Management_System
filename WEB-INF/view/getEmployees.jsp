<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Hr Management</title>
<style>
div.scrollmenu {
    background-color:#FBFBFB;
    overflow: auto;
    white-space: nowrap;
}

div.scrollmenu a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px;
    text-decoration: none;
}

div.scrollmenu a:hover {
    background-color: #FBFBFB;
}
</style>
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
    <div class="scrollmenu">       
<a:choose><a:when test="${employees.size()==0}"><h1>No details found</h1></a:when>
<a:when test="${employees.size() != 0}">
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
<a:forEach items="${employees}" var="i">
<tr>
<td>${i.psno}</td>
<td>${i.firstName}</td>
<td>${i.middleName}</td>
<td>${i.lastName}</td>
<td>${i.dob}</td>
<td>${i.doj}</td>
<td>${i.address}</td>
<td>${i.phoneno}</td>
<td>${i.percent10}</td>
<td>${i.board10}</td>
<td>${i.percent12}</td>
<td>${i.board12}</td>
<td>${i.percentGrad}</td>
<td>${i.degree}</td>
<td>${i.branch}</td>
<td>${i.projectId}</td>
<td>${i.skills}</td>
</tr>
</a:forEach>
</table>
</a:when>
</a:choose>
<form action = "recruitedList.html" method="post">
<input type="submit" name="submit" value="Recruit" />
</form>
</div>
<br><a href="getEmployeeById.html">Search Employee</a><br><br>
<a href="deleteEmployee.html">Delete Employee</a>
</div>
</body>
</html>