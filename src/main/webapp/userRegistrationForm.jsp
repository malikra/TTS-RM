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

    <link rel="stylesheet" href="css/style.css">
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <base href="https://demos.telerik.com/kendo-ui/datepicker/index">
    <style>html {
        font-size: 14px;
        font-family: Arial, Helvetica, sans-serif;
    }</style>
    <title></title>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.common-material.min.css"/>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.material.min.css"/>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.material.mobile.min.css"/>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


    <script src="https://kendo.cdn.telerik.com/2018.1.117/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2018.1.117/js/kendo.all.min.js"></script>

</head>
<body>
<div class="form">

    <div id="userRegister">
        <h1>Sign Up for Free</h1>

        <form action="/createUser" method="post" name="registration">

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
                    <input id="dateOfBirth" required autocomplete="off"/>
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
                <input type="password" name="password" value="" class="input_Password" required autocomplete="off"/>
            </div>

            <div class="field-wrap">
                <label>
                    Confirm Password<span class="req">*</span>
                </label>
                <input type="password" name="password" value="" class="input_re-Password" required autocomplete="off"/>
            </div>

            <button class="button button-block"/>
            Get Started</button>

        </form>

    </div>

</div>

<script type="text/javascript">
    function validate() {
        var val = registration.password.value;
        if (val == null || val.trim() == "") {
            alert('Please enter password.');
            registration.password.focus();
            return false; // cancel submission
        } else {
            document.registration.submit(); // allow submit
        }
    }
</script>
<script>
    $(document).ready(function () {
        // create DatePicker from input HTML element
        $("#dateOfBirth").kendoDatePicker({
            value: new Date(),
            dateInput: true
        });
    });
</script>
</body>
</html>
