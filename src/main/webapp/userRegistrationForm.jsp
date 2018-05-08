<%--
  Created by IntelliJ IDEA.
  User: rashidmalik
  Date: 2/14/18
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
    <%--Date picker css --%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <title></title>

</head>
<body>
<div class="form">

    <div id="userRegister">
        <h1>Sign Up for Free</h1>

        <form action="${pageContext.request.contextPath }/userController?action=addUser" method="post"
              name="registration">

            <div class="field-wrap">
                <label>
                    First Name<span class="req">*</span>
                </label>
                <input type="text" name="firstName" class="input_FirstName" required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    Last Name<span class="req">*</span>
                </label>
                <input type="text" name="lastName" class="input_LastName" required autocomplete="off"/>
            </div>

            <div class="top-row">
                <div class="field-wrap">
                    <label>
                        Date Of Birth<span class="req">*</span>
                    </label>
                </div>
                <div class="field-wrap">
                    <input id="dateOfBirth" name="dateOfBirth" type="text" required autocomplete="off"/>
                </div>
            </div>
            </br>
            <div class="field-wrap">
                <label>
                    userName<span class="req">*</span>
                </label>
                <input type="text" name="userName" value="" class="input_UserName" required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    Password<span class="req">*</span>
                </label>
                <input type="password" id="password" name="password" value="" class="input_Password" required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    Confirm Password<span class="req">*</span>
                </label>
                <input type="password" id="confPassword" name="confPassword" value="" class="input_re-Password" onblur="validate()" required autocomplete="off"/>
            </div>

            <button class="button button-block"/>
            Get Started</button>
        </form>
        <br>
        <form action="${pageContext.request.contextPath }/home.jsp" method="get">
            <button class="myButton">Home</button>
        </form>
    </div>

</div>

<script type="text/javascript">
    function validate() {
        var x= document.getElementById("password");
        var y= document.getElementById("confPassword");
        if(x.value==y.value) return;
        else alert("password not same");
    }
</script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
<%--date picker--%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(function () {
        $("#dateOfBirth").datepicker({
            changeMonth: true,
            changeYear: true,
            format: 'yyyy-MM-dd'
        });
    });
</script>
</body>
</html>
