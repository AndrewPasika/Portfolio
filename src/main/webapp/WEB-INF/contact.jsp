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
<body>
<jsp:include page="pageParts/header.jsp"/>

<form action="/contact" method="POST" align="center">
    <p><b>Your name</b><br>
        <input type="text" size="48" name="name" maxlength="50">
    </p>
    <p><b>Your email*</b><br>
        <input type="text" size="48" name="email" maxlength="50">
    </p>

    <p><b>Subject</b><br>
        <input type="text" size="48" name="email" maxlength="50">
    </p>

    <p><b>Message*</b><br>
        <textarea name="comment" cols="50" rows="6" maxlength="10000"></textarea>
    </p>

    <a href="http://www.ukr.net">link</a>
    <form action="Script URL" method="GET|POST">
        form elements like input, textarea etc.
    </form>

    <p><input type="submit" value="Send"></p>
</form>
</body>
<jsp:include page="pageParts/footer.jsp"/>
</html>
