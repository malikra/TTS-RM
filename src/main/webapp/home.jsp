<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="form">

    <ul style="width: 110%" class="tab-group">
        <li><a href="${pageContext.request.contextPath }/userRegistrationForm.jsp">Sign Up</a></li>
        <%--<li class="tab active"><a href="#login">Log In</a></li>--%>
        <li><a href="${pageContext.request.contextPath }/userLogin.jsp">Log In</a></li>
        <li><a href="${pageContext.request.contextPath }/userInfo.jsp">Admin</a></li>
    </ul>
    <div style="text-align: center">
        <img style="width: 100%; border: 1px solid red" src="image/eventTracking.jpg" alt="event tracking pic">

    </div>
</div> <!-- /form -->

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>


</body>

</html>
