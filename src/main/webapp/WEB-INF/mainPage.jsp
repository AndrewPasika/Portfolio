<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="userList" class="model.javaBeans.UserBean"/>

<html>
    <head>
        <title>My portfolio</title>
    </head>
    <jsp:include page="pageParts/header.jsp"/>

    <jsp:useBean id="entry"
                 class="model.javaBeans.UserBean" />

    <jsp:include page="pageParts/footer.jsp"/>
</html>
