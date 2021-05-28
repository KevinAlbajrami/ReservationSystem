<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
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
<h1>FLIGHT RESERVATION SYSTEM</h1>
<h2>Contact Form</h2>
<body>
<form style="display: flex;
justify-content: center;
vertical-align: middle;" action="sendEmail" method="post">
<pre>
Sender Email:
<input type="text" name=email required/>
Sender Name:
<input type="text" name=name required/>
Message:
<input style="height:100px" type="text" name=message required/>
<input type="submit" value="Send"/>
</pre>
</form>
${msg }
</body>
</html>