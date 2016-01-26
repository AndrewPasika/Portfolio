<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 27.11.2015
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>The include Directive Example</title>
</head>
<body>
<div align="left">${welcome} ${name}</div>
<table style="width:15%" align="right">
    <tr>
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
                <input type="submit" value="Contact">
            </form>
        </td>
        <td>
            <form action="/login" method="GET">
                <input type="submit" value="Sign in">
            </form>
        </td>
        <c:if test="${userBean == null}">
        <td>
            <form action="/registration" method="GET">
                <input type="submit" value="Register">
            </form>
        </td>
        </c:if>
    </tr>
</table>

<br/><br/>