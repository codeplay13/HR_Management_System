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
        <a href="emp_dashboard.html" class="w3-bar-item w3-button">Home</a>
      <a href="profile.html" class="w3-bar-item w3-button">UserProfile</a>
      <a href="timesheet.html" class="w3-bar-item w3-button">Timesheet</a>
      <a href="payrollStatus.html" class="w3-bar-item w3-button">Payroll</a>
      <a href="announcements.html" class="w3-bar-item w3-button">Announcements</a>
       <a href="leave.html" class="w3-bar-item w3-button">Apply for Leave</a>
       <a href="displayTimesheetEmp.html" class="w3-bar-item w3-button">Timesheet Status</a>
       <a href="feedback.html" class="w3-bar-item w3-button">FeedBack</a>
       <a href="complaint.html" class="w3-bar-item w3-button">Complaint</a>
</div>

        <div style="margin-left:25%">
         <div class="w3-container w3-teal">
               <h3>Welcome 
               	<%
					out.println(session.getAttribute("userName"));
				%></h3>
           </div>
	<h2>Leave request sent!</h2>
 </div>
</body>
</html>