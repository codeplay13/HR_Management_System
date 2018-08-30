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
<form method="post" action="registration.html">
	<p>First Name: <br> <input type="text" name="firstName" required><br>
	<p>Last Name: <br> <input type="text" name="lastName" required><br>
	<p>Middle Name: <br> <input type="text" name="middleName" required><br>
	<p>Date of Birth: <br> <input type="date" name="dob" required><br>
	<p>Date of Joining: <br> <input type="date" name="doj" required><br>
	<p>Address: <br> <input type="text" name="address" required><br>
	<p>Phone Number: <br> <input type="text" name="phoneno" required><br>
	<p>10th Percentage: <br> <input type="number" step="0.01" name="percent10" required><br>
	<!-- <p>10th Board: <br> <input type="text" name="board10"><br> -->
	<p>10th Board: <br> 
		<select name="board10" id="board10">
			<option value="SSC">SSC</option>
			<option value="ICSE">ICSE</option>
			<option value="CBSE">CBSE</option>
		</select>
	<p>12th/Diploma Percentage: <br> <input type="number" step="0.01" name="percent12" required><br>
	<!-- <p>12th/Diploma Board/University: <br> <input type="text" name="board12"><br> -->
	<p>12th/Diploma Board/University: <br>
	<select name="board12" id="board12">
		<option value="HSC">HSC</option>
		<option value="Diploma">Diploma</option>
		<option value="Others">Others</option>
	</select>
	<p>Graduation Percentage: <br> <input type="number" step="0.01" name="percentGrad" required><br>
	<!-- <p>Degree: <br> <input type="text" name="degree"><br> -->
	<p>Degree: <br> 
	<select name="degree" id="degree">
		<option value="BE">BE</option>
		<option value="BTECH">BTECH</option>
		<option value="BSC">BSC</option>
	</select>
	<!-- <p>University: <br> <input type="text" name="university"><br> -->
	<p>University: <br>
	<select name="university" id="university">
		<option value="Mumbai">Mumbai</option>
		<option value="Pune">Pune</option>
	</select>
	<!-- <p>Branch: <br> <input type="text" name="branch"><br> -->
	<p>Branch: <br>
	<select name="branch" id="branch">
		<option value="IT">IT</option>
		<option value="COMPS">COMPS</option>
		<option value="EXTC">EXTC</option>
		<option value="Civil">Civil</option>
	</select>
	<p>Project Id<br> <input type="text" name="projectId"><br>
	<p>Skills<br> <input type="text" name="skills" required><br>
	<p>Password<br> <input type="password" name="password" required><br>
	<p>Security Keyword (Remember this in case you forgot password):<br> <input type="text" name="answer" required><br><br>
	<input type="submit" name="submit" value="Submit" />
	</form>
</div>
</body>
</html>