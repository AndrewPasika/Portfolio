<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 23.11.2015
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Contact</title>
    <meta name="description" content="It is the contact page. You can ask me any questions here.">
    <meta name="keywords" content="contact, feedback, message, questions">
</head>
<body>
<jsp:include page="pageParts/header.jsp"/>

<div align="center">
<form action="/contact" method="POST">
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

    <p><input type="submit" value="Send"></p>
</form>
</div>
</body>
<jsp:include page="pageParts/footer.jsp"/>
</html>
