<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<jsp:useBean id="user" class="com.sunbeam.beans.RegistrationBean"/>
<jsp:setProperty name="user" property="fname" param="fname"/>
<jsp:setProperty name="user" property="lname" param="lname"/>
<jsp:setProperty name="user" property="email" param="email"/>
<jsp:setProperty name="user" property="pass" param="pass"/>
<jsp:setProperty name="user" property="dob" param="dob"/>

	
<div>


<c:choose>
		<c:when test="${user.register()}">
			<div>
			<h1>User is Added;</h1>
			<a href="index.jsp">Login</a>
			</div>
		</c:when>
		<c:otherwise>
		<div>
			<h1>User is Not added..Please try again.</h1>
			<a href="/WEB-INF/views/newuser.jsp">Retry</a>
			</div>
		</c:otherwise>
</c:choose>


</div>

</body>
</html>