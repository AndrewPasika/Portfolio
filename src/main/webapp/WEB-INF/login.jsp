<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 13.11.2015
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<jsp:include page="pageParts/header.jsp"/>

<div align="center">
<form action="/login" method="POST">
    <br>
    Login/Email:<br>
    <input type="text" name="loginOrEmail" maxlength="30">
    <br>
    Password:<br>
    <input type="password" name="password" maxlength="30">
    <br><br>
    <input type="submit" value="Submit">

    <br><br>
    ${error}

    <%@ page errorPage="errorPages/authenticationError.jsp" %>
</form>
</div>

<jsp:include page="pageParts/footer.jsp"/>
</html>
