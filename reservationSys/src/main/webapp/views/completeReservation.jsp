<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
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
th, td {
  padding: 15px;
  text-align: left;
}
</style>
</head>
<body>
<h2>Complete Reservation</h2>
Code: ${flight.code }<br/>
Destination: ${flight.destination }<br/>
Time: ${flight.depTime }<br/>

<form action="completeReservation" method="get">
<pre>
<h3>Passenger Details:</h3>
First Name: 	<input type="text" name="fName"/>
Last Name:  	<input type="text" name="lName"/>
Email: 		<input type="text" name="email"/>

<h3>Card Details:</h3>
Name: 		<input type="text" name="nameCard"/>
Number: 	<input type="text" name="numberCard"/>
Code: 		<input type="text" name="codeCard"/>
<input type="hidden" name=flightId value="${flight.id}"/>
<input type="submit" value="confirm"/>
</pre>
</form>
</body>
</html>