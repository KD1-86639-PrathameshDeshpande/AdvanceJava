<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CandidateList</title>
</head>
<body align="center">
<h1>Candidate List</h1>
<jsp:useBean id="cand" class="com.sunbeam.beans.CandidateListBean"/>
<c:forEach var="candidate" items="${cand.candidatedisplay()}">
<input type="radio" name="candidate"/>${candidate.getName()}<br>
</c:forEach>
<input type="submit" value="submit"/>




</body>
</html>