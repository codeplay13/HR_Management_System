<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
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

<form action = "getComplaintByPsno.html" method="post">
<p>Enter PS Number:<br> <input type="text" name="psno"><br><br>
		<input type="submit" name="submit" value="Submit" />
<a:choose><a:when test="${complaint.size()==0}"><h1>No complaints</h1></a:when>
<a:when test="${complaint.size() != 0}">
<table border = "1">
<tr>
<th>PS Number</th>
<th>Time Added</th>
<th>Department</th>
<th>Complaints</th>
</tr>
<a:forEach items="${complaint}" var="i">
<tr>
<td>${i.psno}</td>
<td>${i.complaintDate}</td>
<td>${i.department}</td>
<td>${i.complaintText}</td>
</a:forEach>
</table>
</a:when>
</a:choose>
</form>
</div>	
</body>
</html>