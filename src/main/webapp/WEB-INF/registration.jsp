<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 15.11.2015
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<jsp:include page="pageParts/header.jsp"/>

<c:if test="${userBean == null}">
<div align="center">
<form action="/registration" method="POST">
    <label for="firstname">First name:</label><br>
    <input type="text" name="firstname" id="firstname" maxlength="30">
    <br><br>
    <label for="surname">Surname:</label><br>
    <input type="text" name="surname" id="surname" maxlength="30">
    <br><br>
    <label for="email">*Email:</label><br>
    <input type="text" name="email" id="email" maxlength="30">
    <br><br>
    <label for="login">*Login:</label><br>
    <input type="text" name="login" id="login" maxlength="30">
    <br><br>
    <label for="password">*Password:</label><br>
    <input type="password" name="password" id="password" maxlength="30">
    <br><br>
    <label for="confPass">*Confirm password:</label><br>
    <input type="password" name="confPass" id="confPass" maxlength="30">
    <br><br>
    <input type="submit" value="Submit">
    <br><br>
    </c:if>
    <div align="center">${message}</div>
</form>
</div>
<jsp:include page="pageParts/footer.jsp"/>
</html>
