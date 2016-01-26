<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 04.12.2015
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table style="width:auto">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>login</th>
        <th>email</th>
        <th>id</th>
    </tr>
    <tr>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.login}</td>
        <td>${user.email}</td>
        <td>${user.id}</td>
    </tr>
</table>
</body>
</html>
