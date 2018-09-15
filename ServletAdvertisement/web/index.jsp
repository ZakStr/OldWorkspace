<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.03.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Log in</title>
</head>
<body bgcolor="#FAEBD7">
<form action="/advertisement" method="POST">
    <h2>Sign In</h2>
    <h4>(If you have an account)</h4><br>
    Login: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Enter"/>
</form>
<br><br><br><br><br>

<form action="/advertisement" method="POST">
    <h2>Sign Up </h2>
    <h4>(If you don't have an account)</h4><br>
    Name: <input type="text" name="name">&nbsp;&nbsp;&nbsp;
    Surname: <input type="text" name="surname">&nbsp;&nbsp;&nbsp;
    Email: <input type="text" name="email"><br><br>
    Your login: <input type="text" name="newLogin">
    Your password: <input type="password" name="newPassword"><br>
    <input type="submit" value="Up"/>
</form>
</body>
</html>