<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Flight</title>
</head>
<body>
<form style="display: flex;
justify-content: center;
vertical-align: middle;" action="updateFlight" method="post">
<pre>
ID: <input type="text" name="id" value="${flight.id}" readonly/> 
Code: <input type="text" name="code" value="${flight.code}"/>
Destination: <input type="text" name="destination" value="${flight.destination}"/>
Date: <input type="text" name="depDate" value="${flight.depDate}"/>
Time: <input type="text" name="depTime" value="${flight.depTime}"/>
<input style="background-color:powderblue; width:150px; height:30px; font-size: 15px; position: absolute;
    top: 55%;
    left: 53%;
    padding:5px;
    color:black;
    transform: translateX(-50%) translateY(-50%);
    " type="submit" value="Submit"/>
</pre>
</form>
</body>
</html>