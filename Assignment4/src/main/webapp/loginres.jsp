<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loginres</title>
</head>
<body>
<div>
<jsp:useBean id="lo" class="com.sunbeam.beans.LoginBean"/>
<jsp:setProperty name="lo" property="email" param="email"/>
<jsp:setProperty name="lo" property="password" param="password"/>


<c:choose>
		<c:when test="${lo.login()}">
			<div>
			<c:redirect url="candlist.jsp"/>
	
			</div>
		</c:when>
		<c:otherwise>
		<div>
			<h1>Please try again.</h1>
			<a href="login.jsp">Login</a>
			</div>
		</c:otherwise>
</c:choose>


</div>

</body>
</html>