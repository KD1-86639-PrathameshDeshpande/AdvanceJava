<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Cand</title>
</head>
<body>
<jsp:useBean id="addn" class="com.sunbeam.beans.NewCandidate"/>


<jsp:setProperty name="addn" property="*"/>
		${addn.addCandidate()}
		<c:choose>
				<c:when test="${addn.count == 1}">
				<jsp:forward page="/WEB-INF/views/result.jsp">
				<jsp:param name="msg" value="Candidate Added Successfully." />
			</jsp:forward>
						
				</c:when>
				<c:otherwise>
					<jsp:forward page="/WEB-INF/views/result.jsp">
				<jsp:param name="msg" value="Candidate Not Added." />
			</jsp:forward>
				</c:otherwise>
			</c:choose>

</body>
</html>