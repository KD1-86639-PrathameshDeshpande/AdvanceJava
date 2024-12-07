<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*"/>
	${lb.login()}
	<c:choose>
		<c:when test="${lb.u != null}">
			
			
			<c:choose>
				<c:when test="${lb.u.role == 'admin'}">
					<c:redirect url="/WEB-INF/views/result.jsp"/>	
				</c:when>
				<c:otherwise>
					<c:redirect url="/WEB-INF/views/candlist.jsp"/>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h2>Login Failed</h2>
			<p>
			Invalid email or password.
			</p>
			<p>
			<a href="index.jsp">Login Again</a>
			</p>
		</c:otherwise>
	</c:choose>


</div>

</body>
</html>