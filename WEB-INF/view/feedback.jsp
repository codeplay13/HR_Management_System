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
<form method="post" action="feedback.html">
		<h1>Feedback</h1>
		<p>Your psno:<br> <input type="text" name="psno" value="${psNo}" readonly><br>
		<p>Time:<br><input type="text" name="feedbackDate" value="<%= (new java.util.Date())%>" readonly/><br>
		<!-- <p>Department:<br> <input type="text" name="department"/><br> -->
		<p>Department:<br>
		<select name="department" id="department">
			<option value="Others">Others</option>
			<option value="Hr">HR</option>
			<option value="Admin">Admin</option>
			<option value="Canteen">Canteen</option>		
			<option value="Travel">Travel</option>
		</select>
		<p>On a scale of 1 to 10, how happy are you at work?<br>
		<select name="question1" id="question1">
			<option value="1">1(lowest)</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10(highest)</option>
		</select>
		<br>
		<p>On a scale of 1 to 10, how would you rate your work-life balance?<br>
		<select name="question2" id="question2">
			<option value="1">1(lowest)</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10(highest)</option>
		</select>
		<br>
		<p> Hypothetically, if you were to quit tomorrow, what would your reason be?<br> <input type="text" name="question3"/><br>
		<p>Feedback:<br> <input type="text" name="feedbackText"/><br><br>
		<input type="submit" name="submit" value="Submit" />
		<!-- <h5><a href = "allFeedback.html">Display all Feedbacks</a></h5>
		<h5><a href = "getFeedbackByPsno.html">Get Feedback by PS Number</a></h5> -->
	</form>
 </div>
</body>
</html>