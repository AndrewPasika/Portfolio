<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 27.11.2015
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="author" content="Andrew Pasika" />
    <meta name="Reply-to" content="Pasika2012@gmail.com" />
    <meta name="Owner" content="Andrew Psika" />
    <meta name="description" content="This is Andrew Pasika's personal site.
    Here you can find all the information about him.">
    <meta name="keywords" content="Andrew, Pasika, portfolio, blog">
</head>
<body>
<div align="left">${welcome} ${name}</div>
<table style="width:15%" align="right">
    <tr>
        <c:if test="${not empty sessionScope.userBean}">
            <td>
                <form action="/profile">
                    <input type="submit" value="Profile page">
                </form>
            </td>
        </c:if>
        <c:if test="${userBean.id == 1}">
        <td>
            <form action="/admin">
                <input type="submit" value="Admin page">
            </form>
        </td>
        </c:if>
        <td>
            <form action="/">
                <input type="submit" value="Main page">
            </form>
        </td>
        <td>
            <form action="/contact" method="GET">
                <input type="submit" value="Contacts">
            </form>
        </td>
        <c:if test="${empty sessionScope.userBean}">
        <td>
            <form action="/login" method="GET">
                <input type="submit" value="Log in">
            </form>
        </td>
        </c:if>
        <c:if test="${userBean == null}">
        <td>
            <form action="/registration" method="GET">
                <input type="submit" value="Register">
            </form>
        </td>
        </c:if>
        <c:if test="${not empty sessionScope.userBean}">
            <td>
                <form action="/logout" method="POST">
                    <input type="submit" value="Log out">
                </form>
            </td>
        </c:if>
    </tr>
</table>
</body>
<br/><br/>