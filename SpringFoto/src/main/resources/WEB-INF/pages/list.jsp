<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Prog.kiev.ua</title>
</head>
<body bgcolor="#FAEBD7">

<div align="center">

    <form action="/deletePhoto" method="POST">

        <fieldset>
            <legend><strong><h1>All uploaded photo:</h1></strong></legend>

            <c:forEach items="${listId}" var="photoId">

                <p><input type="checkbox" name="photo" value=${photoId}>&nbsp;${photoId}&nbsp;&nbsp;&nbsp;<img
                        src="/photo/${photoId}" width="75" height="75"/></p>

            </c:forEach>

            <p><input type="submit" value="Delete Photo(s)"></p>

        </fieldset>

    </form>

    <input type="submit" value="Upload New" onclick="window.location='/';"/>
</div>
</body>
</html>