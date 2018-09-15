<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Prog.kiev.ua</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor="#FAEBD7">

<div align="center">

    <form action="/load" enctype="multipart/form-data" method="POST">
        <fieldset>
            <legend><strong><h1>Archive Zip - WinRAR:</h1></strong></legend>
            <img height="25" width="30" src="<c:url value="/static/File.png"/>" title="Choose Files"/><input type="file"
                                                                                                             name="files"
                                                                                                             multiple>
            <input type="submit" value="Load"/>
        </fieldset>
    </form>


    <c:if test="${flag}">

        <div align="center">
            <fieldset>
                <legend><input type="image" height="100" width="100" src="<c:url value="/static/RAR.png"/>"
                               title="Click to download (WinRAR.rar)"
                               onclick="window.location='/download/${files_id}';"/></legend>

                <div align="left">
                    <h1>Your files is:</h1>
                    <c:forEach items="${files}" var="files">
                        &#128190;&nbsp;${files.getOriginalFilename()}<br>
                    </c:forEach>
                </div>
            </fieldset>
        </div>

    </c:if>

</div>

</body>
</html>
