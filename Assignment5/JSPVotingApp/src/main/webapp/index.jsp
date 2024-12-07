<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body align="center">
<h1>Login</h1>
<form method="post" action="/WEB-INF/views/loginres.jsp">
<p>
Email: <input type="email" name="email" /> <br><br>
Password: <input type="password" name="password"/><br><br>
<input type="submit" value="Sign In" /><br><br>

New User? <a href="/WEB-INF/views/newuser.jsp">Sign Up</a> <br><br>
</form>

</body>
</html>