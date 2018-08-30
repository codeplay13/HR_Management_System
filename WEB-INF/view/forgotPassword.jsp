<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="forgotPassword.html">
		<h1>Reset Password</h1>
		<p>PS Number<br> <input type="text" name="psno" required><br>
		<p>Security Keyword <br> <input  type="text" name="ans" required><br>
		<p>New Password<br> <input id="password" type="password" name="npass" placeholder="Password" required><br>
		<p>Confirm password<br> <input id="confirm_password" type="password" name="cpass" placeholder="Confirm password" required><br><br>
		<input type="submit" name="submit" value="Submit" />
	</form>
</body>
<script type="text/javascript">var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;</script>
</html>