<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<style>
body {background-color: white;}
h1   {color: #DCDCDC;
background-color: #696969;
font-family: courier;
font-size: 50px;
text-align:center;
height: 120px;
display: flex;
justify-content: center;
vertical-align: middle;
}
h2   {color: #DCDCDC;
background-color: #696969;
font-family: courier;
font-size: 40px;
text-align:center;
height: 60px;
display: flex;
justify-content: center;
vertical-align: middle;
}
p    {color: red;}
</style>
</head>
<body>
<h1>FLIGHT RESERVATION SYSTEM</h1>
<form style="display: flex;
justify-content: center;
vertical-align: middle;" action="registerUser" method="post">
<h2>User Registration</h2>
<pre>
	First Name:  	 <input type="text" name="fName" required="required"/>
	Last Name: 	 <input type="text" name="LName" required="required"/>
	Email:      	 <input type="text" name="email" required="required"/>
	Password:   	 <input type="password" name="password" required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/>
	Confirm Password:<input type="password" name="passwordC" required="required"/>
	<input style="background-color:powderblue; width:150px; height:30px; font-size: 15px; position: absolute;
    top: 55%;
    left: 58%;
    padding:5px;
    color:black;
    transform: translateX(-50%) translateY(-50%);
    " type="submit" value="register">
   
	</pre>
</form>
 <p>${msg}</p>
</body>
</html>