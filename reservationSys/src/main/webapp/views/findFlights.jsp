<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
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
<h2>Find Flights</h2>
<form style="display: flex;
justify-content: center;
vertical-align: middle;" action="findFlights" method="post">
	Destination: <input style="padding:5px" type="text" name="destination"/>
	Departure Date: <input style="padding:5px" type="text" name="depDate"/>
	<input  style="background-color:powderblue; width:150px; height:30px; font-size: 15px;
	display: flex;
    padding:5px;
    text-align:center;
    color:black;
    " type="submit" value="search">
</form>

</body>
</html>