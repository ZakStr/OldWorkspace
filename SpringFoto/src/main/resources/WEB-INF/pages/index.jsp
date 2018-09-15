<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Prog.kiev.ua</title>
</head>
<body bgcolor="#FAEBD7">

<div align="center">

    <form action="/view" method="POST">
        <fieldset>
            <legend><strong>Id:</strong></legend>
            &#8470;&nbsp;<input type="text" name="photo_id" placeholder="Photo id:">
            <input type="submit" value="&#128269;"/>
        </fieldset>
    </form>

    <form action="/add_photo" enctype="multipart/form-data" method="POST">
        <fieldset>
            <legend><strong>Photo:</strong></legend>
            <img height="25" width="30" src="<c:url value="/static/Picture.png"/>" title="Choose Pictures"/><input
                type="file" name="photo">
            <input type="submit" value="Load"/>
        </fieldset>
    </form>

</div>
</body>
</html>
