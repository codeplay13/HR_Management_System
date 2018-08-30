<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
	<form method="post" action="complaint.html">
		<h1>Complaint</h1>
		<p>Your psno:<br> <input type="text" name="psno" value="${psNo}" readonly><br>
		<p>Time:<br><input type="text" name="complaintDate" value="<%= (new java.util.Date())%>" readonly/><br>
		<!-- <p>Department you want to complaint about:<br> <input type="text" name="department"/><br> -->
		<p>Department you want to complaint about:<br>
		<select name="department" id="department">
			<option value="Others">Others</option>
			<option value="Hr">HR</option>
			<option value="Admin">Admin</option>
			<option value="Canteen">Canteen</option>		
			<option value="Travel">Travel</option>
		</select>
		<p>Complaint:<br> <input type="text" name="complaintText" required><br><br>
		<input type="submit" name="submit" value="Submit" />
	<!-- 	<h5><a href = "allComplaint.html">Display all Complaints</a></h5>
		<h5><a href = "getComplaintByPsno.html">Get Complaint by PS Number</a></h5> -->
	</form>
</div>

</body>
</html>