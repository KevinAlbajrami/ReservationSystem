<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
<h2>Login:</h2>
<form style="display: flex;
justify-content: center;
vertical-align: middle;" action="login" method="post">
<pre>
Username: <input type="text" name="email" required="required"/>
Password: <input type="password" name="password" required="required"/>
<input style="background-color:powderblue; width:150px; height:30px; font-size: 15px; position: absolute;
    top: 55%;
    left: 53%;
    padding:5px;
    color:black;
    transform: translateX(-50%) translateY(-50%);
    " type="submit" value="login"/>
${msg}
</pre>
</form>
</body>
</html>