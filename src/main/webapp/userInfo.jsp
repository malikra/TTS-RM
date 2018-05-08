<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/head.jsp" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>User Info</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="form">
    <div id="userlogin">
        <h1>User Info</h1>

        <form action="${pageContext.request.contextPath }/userController?action=searchUser" class="form-inline"
              method="post">
            <div class="top-row">
                <div class="field-wrap">
                    <c:choose>
                        <c:when test="${not empty message}">
                            <div style="color: sandybrown">
                                <c:out value="${message}"></c:out>
                            </div>
                        </c:when>
                    </c:choose>
                </div>
            </div>
            <div class="top-row">
                <div class="field-wrap">
                    <div class="form-group">
                        <label for="lastName">Search</label>
                        <input type="text" class="form-control" id="lastName" name="lastName"
                               aria-describedby="searchTermHelp"
                               placeholder="Enter last name">
                    </div>
                </div>
            </div>
            <div class="top-row">
                <div class="field-wrap">
                    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
                    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>
                </div>
            </div>
        </form>
        <div class="top-row">
            <div class="field-wrap">
                <form style="float: left" action="${pageContext.request.contextPath }/signOutController" method="post">
                    <button class="myButton">Home</button>
                </form>
            </div>
        </div>
    </div>
</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>