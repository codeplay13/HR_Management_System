<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
       <a href="profile.html" class="w3-bar-item w3-button">UserProfile</a>
      <a href="timesheet.html" class="w3-bar-item w3-button">Timesheet</a>
      <a href="payrollStatus.html" class="w3-bar-item w3-button">Payroll</a>
      <a href="announcements.html" class="w3-bar-item w3-button">Announcements</a>
       <a href="leave.html" class="w3-bar-item w3-button">Apply for Leave</a>
       <a href="displayTimesheetEmp.html" class="w3-bar-item w3-button">Timesheet Status</a>
       <a href="feedback.html" class="w3-bar-item w3-button">FeedBack</a>
        <a href="displayLeaveEmp.html" class="w3-bar-item w3-button">Leave Status</a>
       <a href="complaint.html" class="w3-bar-item w3-button">Complaint</a>
       <a href="logout.html" class="w3-bar-item w3-button">Logout</a>
       
</div>
  
<div style="margin-left:25%">
         <div class="w3-container w3-teal">
               <h3>Welcome 
               	<%
			out.println(session.getAttribute("userName"));
		%></h3>
           </div>

<table border="1">
				<tr>
					<th>PS NO</th>
					<th>Comment</th>
					<th>EntryDate</th>
					<th>InTime</th>
					<th>OutTime</th>
					<th>Status</th>
					
				</tr>
				<c:forEach items="${list}" var="i">
				<c:if test="${emp_psno==i.psno}">
					<tr>
						<td>${i.psno}</td>
						<td>${i.commentDesc}</td>
						<td>${i.entryDate}</td>
						<td>${i.inTime}</td>
						<td>${i.outTime}</td>
						
						<td><c:choose>
							<c:when test="${i.timesheetStatus==1}"> Approved</c:when>
							<c:when test="${i.timesheetStatus==2}"> Rejected</c:when>
							<c:otherwise>Pending</c:otherwise>
							</c:choose>
						</td>	
					</tr>
					</c:if>
				</c:forEach>
				
			</table>
			
	</div>		
			
			
			
	
</body>
</html>