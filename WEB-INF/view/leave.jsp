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
    <form action="leave.html" method="post">
							<div>
								<p></p>
								<label>From</label><br> <input type="date" name="fromDate"><br>
							</div>
							<div>
								<label>To</label><br> <input type="date" name="toDate">
							</div>


							<div>
								<p></p>
								<label>Reason</label> <br>
								<select name="leaveReason" id="leaveReason">
									<option value="Other">Others</option>
									<option value="Annual Leave">Annual leave</option>
									<option value="Bereavement">Bereavement</option>
									<option value="Unpaid Leave">Unpaid Leave</option>
									<option value="Maternity Leave">Maternity Leave</option>								
								</select>
							
							</div>
							<div>
					<!-- 			<textarea name="leaveReason" rows="4" cols="60">
                       
                       </textarea> -->
                       
                       <p>Time:<br><input type="text" name="applyDate" value="<%= (new java.util.Date())%>" readonly/><br><br>
							</div>
							<div>
								<button type="submit" class="btn btn-outline">Submit</button>
							</div>
  </form>
  </div>
  <a href="displayLeaveEmp.html">Display Leave Details</a>
</body>
</html>