<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="userList" class="model.javaBeans.UserBean"/>
<%--<jsp:directive.include file="/resources/assets/css/style.css" />--%>

<html>
    <head>
        <title>My portfolio</title>
        <link rel="stylesheet" type="text/css" href="../resources/assets/css/style.css/">
        <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css/">
        <link rel="stylesheet" type="text/css" href="./resources/assets/css/style.css/">
        <link rel="stylesheet" type="text/css" href="resources/assets/css/style.css/">

    </head>
    <jsp:include page="pageParts/header.jsp"/>

    <div class="main">

        <div class="header">
            <div class="logo">
                <div class="my_name">
                    <h1>Andrew Pasika</h1>
                    <h4>Hello World!</h4>
                    <h4>sout</h4>
                    <h4>Object</h4>
                    <h4>for(int k : array){}</h4>
                </div>
            </div>
        </div>

    </div>

    <jsp:include page="pageParts/footer.jsp"/>
</html>
