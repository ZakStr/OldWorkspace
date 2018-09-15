<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.03.2017
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Advertisement</title>
</head>
<body bgcolor="#FAEBD7">
<% String login = (String) session.getAttribute("user_login"); %>

<table align='right' border='0' width="50%">
    <caption><h1>List of all advertisement</h1></caption>
    <c:forEach items="${messageList}" var="message">
    <tr>
        <td><c:out value="${message.getDate() }"></c:out></td>
        <td></td>
        <td><c:out value="${message.getText() }"></c:out></td>
    <tr>
        </c:forEach>
</table>

<h1>You are logged in as: <%= login %>
</h1>
<form action="/advertisement" method="POST">
    Type advertisement :<br>
    </p>
    <p><textarea name="text" cols="48" rows="8"> </textarea>
    </p>
    <p><input name="submit" type="submit" id="submit" value="Sent"/>
</form>
<br>Click this link to <a href="/advertisement?a=exit">logout</a>
</body>
</html>
