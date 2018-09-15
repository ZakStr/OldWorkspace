<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 20.03.2017
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
%>
<html>
<head>
    <title>Apartments</title>
</head>
<body>
<form action="/apartment" method="POST">
    <fieldset>
        <legend><strong>Specify the path to the file (D:\Other\File.xml):</strong></legend>
        <p><input type="text" name="fileXML">
            <input type="submit" value="Load"></p>
    </fieldset>
</form>
</body>
</html>
