<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Flights</title>
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
<h2>Show All Flights</h2>
<table style="display: flex;
justify-content: center;
vertical-align: middle;
border-style: solid;
border-width:2px;
border-color: orange;
">
<tr style="background-color:lightblue">
<th>Code</th>
<th>Destination</th>
<th>Time</th>
</tr>
<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.code}</td>
<td>${flight.destination}</td>
<td>${flight.depTime}</td>
<td style="background-color:lightgreen"><a href="showUpdate?flightId=${flight.id}">Edit</a></td>
<td style="background-color:orange"><a href="deleteFlight?flightId=${flight.id}">Delete</a></td>
</tr>

</c:forEach>
</table>
<a style="background-color:powderblue; width:150px; height:30px; font-size: 15px;
    padding:5px;
    color:black;
    transform: translateX(-50%) translateY(-50%);
    " href="addFlight">Add Flight</a>
</body>
</html>