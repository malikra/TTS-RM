<%--
  Created by IntelliJ IDEA.
  User: rashidmalik
  Date: 4/22/18
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message Jsp</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="form">
    <h1><c:out value="${message}">No message</c:out></h1>
    <br>
    <c:choose>
        <c:when test="${not empty userCreated}">
            <form action="${pageContext.request.contextPath }/userLogin.jsp" method="get">
                <button class="myButton">Home</button>
            </form>
        </c:when>
        <c:otherwise>
            <form action="${pageContext.request.contextPath }/calender.jsp" method="get">
                <button class="myButton">Home</button>
            </form>
        </c:otherwise>
    </c:choose>
</div>
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>
