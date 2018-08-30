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
               <h1>Welcome ${psno}</h1>
           </div>
	<form method="post" action="addAnnouncement.html">
		<h1>Announcements</h1>
		<p>Your PsNo:<br> <input type="text" name="hrName" value="${psno}" readonly><br>
		<p>Announcement:<br> <input type="text" name="announcement" required><br>
		<p>Time:<br><input type="text" name="entryDate" value="<%= (new java.util.Date())%>" readonly/><br><br>
		<input type="submit" name="submit" value="Submit" /><br><br>
		<a href="allAnnouncementsHr.html">Display Announcements</a> <br>
		<a href="getAnnouncementsByHrHr.html">Display Announcements By Hr</a>
	</form>
  </div>
</body>
</html>