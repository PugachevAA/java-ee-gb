<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType = "text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Message</title>
    </head>

    <body>
        <h2>Message from: ${message.from}</h2>
        <h2>Message to: ${message.to}</h2>
        <h2>Message: ${message.body}</h2>
        <br>
        <c:url var="deleteUrl" value="/message/delete">
            <c:param name="id" value="${message.id}"/>
        </c:url>
        <a href="${deleteUrl}">Delete</a>

        <c:url var="editUrl" value="/message/edit">
            <c:param name="id" value="${message.id}"/>
        </c:url>
        <a href="${editUrl}">Edit</a>
    </body>
</html>
