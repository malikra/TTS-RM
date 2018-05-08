<%--
  Created by IntelliJ IDEA.
  User: rashidmalik
  Date: 4/19/18
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Events</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<div class="form">
    <h1>Event List</h1>
    <a href="${pageContext.request.contextPath }/calanderController?action=add">Add New Event</a>
    <br>
    <div class="field-wrap">
    <table border="1" bgcolor="white">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Option</th>
        </tr>
        <c:forEach var="task" items="${tasks }">
            <tr>
                <td>${task.id }</td>
                <td>${task.taskName }</td>
                <td>${task.startTime }</td>
                <td>${task.endTime }</td>
                <td>
                    <a href="${pageContext.request.contextPath }/calanderController?action=edit&id=${task.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath }/actionController?action=delete&id=${task.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
    <div class="top-row">
        <div class="field-wrap">
            <form style="float: left" action="${pageContext.request.contextPath }/calender.jsp" method="get">
                <button class="myButton">Home</button>
            </form>
        </div>
        <div class="field-wrap">
            <form style="float: right" action="${pageContext.request.contextPath }/signOutController" method="post">
                <button class="myButton">Sign out</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
