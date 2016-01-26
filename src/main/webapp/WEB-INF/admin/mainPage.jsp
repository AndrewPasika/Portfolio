<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: AndriiUSER
  Date: 28.11.2015
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userList" class="model.javaBeans.UserBean" scope="request"/>
<html>
<head>
    <title>Welcome to office</title>
</head>
<jsp:include page="../pageParts/header.jsp"/>

<body>

<form action="/admin" method="POST">
    <input type="submit" value="Show all users">
</form>

    <c:if test="${not empty sessionScope.flag}">
        <jsp:include page="userList.jsp"/>
    </c:if>

</body>
<jsp:include page="../pageParts/footer.jsp"/>
</html>
