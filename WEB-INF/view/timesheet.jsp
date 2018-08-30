<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Hr Management</title>
	<style type="text/css">

			.timesheet_form{
				border: solid 2px black;
				border-radius: 20px;
				padding: 10 10 10 10;

			}
			.timesheet_form{
				margin: 50 30 10 400;
				width: 520px;
			}

			.from_dt_div{
				margin: 60 50 60 20;
				display: inline;
			}

			.to_dt_div{
				margin: 60 50 60 20;
				display: inline;
			}
			.timesheet_submit{
				width: 50px;
				margin: 0 0 0 225;
			}
		</style>
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
	<h2 style="text-align:center">TimeSheet</h2>
	<%-- 	${userName} --%>
		
		<form action="timesheet.html" method="post" class="timesheet_form">

					<br>
			<div class = "from_dt_div">
			<label>Entry Date</label><br>
			<input type="date" name="entryDate"> 
			</div>
			<br><br>
			<label>In Time:</label><br>
			<input type="number" name="inTime" placeholder="24-hour format">
			<br>
			<br>
			<label>Out Time:</label>	<br>
			<input type="number" name="outTime" placeholder="24-hour format">	
				<br>
				<br>
			<label>Comment</label><br>
			<input style="width:300px" type="text" name="commentDesc" >
				<br>
				<br>
			<div class="timesheet_submit">
			<button type="submit" name="timesheet_submit" value="Save">Save</button><br>
			</div>
		</form>
</div>		
		<a href="displayTimesheetEmp.html">Display Timesheet</a>
</body>
</html>