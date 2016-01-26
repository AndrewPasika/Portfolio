<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 23.11.2015
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
</head>
<jsp:include page="pageParts/header.jsp"/>

<form action="/contact" method="POST" align="center">
    <p><b>Name*</b><br>
        <input type="text" size="48" name="name">
    </p>

    <p><b>Email*</b><br>
        <input type="text" size="48" name="email">
    </p>

    <p><b>Message*</b><br>
        <textarea name="comment" cols="50" rows="6"></textarea>
    </p>

    <p><input type="submit" value="Send">
</form>

<jsp:include page="pageParts/footer.jsp"/>
</html>
