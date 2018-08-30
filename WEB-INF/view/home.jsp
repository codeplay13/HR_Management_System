<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR Management System</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}


input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #2A49E8;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}


.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

.center {
    margin: auto;
    width: 50%;
    border: #435DDB;
    padding: 10px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>
<h2 style="color:#54CBEF">HR Management </h2>

<form action="validateUser.html" method="post">
  

<div class="center">
  
   <div class="container">
    <label for="uname" style="color:#DEA114"><b>Username</b></label>
    <input type="text" placeholder="Enter Psno" name="psno" required>

    <label for="psw" style="color:#DEA114"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit">Login</button>
    
 
  </div>
    <span class="psw" style="color:#FEFEFE"><a href="forgotPassword.html">Forgot password?</a></span>
  
</div>
</form>

</body>
</html>