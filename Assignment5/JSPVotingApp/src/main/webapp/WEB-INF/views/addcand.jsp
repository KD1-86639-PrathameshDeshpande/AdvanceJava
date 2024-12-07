<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Candidate</title>
</head>
<body>
<h1>Add New Candidate</h1>
<form method="post" action="/WEB-INF/views/addnewcand.jsp">
Name: <input type="text" name="name" /><br><br>
Party: <input type="text" name="party" /><br><br>

<input type="submit" value="Add Candidate"/>

</form>



</body>
</html>