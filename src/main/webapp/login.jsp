<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2/23/18
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body><!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="form">

    <div id="adminLogin">
        <h1>Login!</h1>

        <form action="j_security_check" method="post">

            <div class="field-wrap">
                <label>
                    User name<span class="req">*</span>
                </label>
                <input class="j_name" type="text" name="j_username" required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    Password<span class="req">*</span>
                </label>
                <input class="j_password" type="password" name="j_password" required autocomplete="off"/>
            </div>

            <p class="forgot"><a href="#">Forgot Password?</a></p>

            <button class="button button-block"/>
            Log in</button>

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
