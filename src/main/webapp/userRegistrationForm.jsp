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
    <base href="https://demos.telerik.com/kendo-ui/datepicker/index">
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.material.mobile.min.css" />

    <script src="https://kendo.cdn.telerik.com/2018.1.117/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2018.1.117/js/kendo.all.min.js"></script>

</head>
<body>
<form action="/createUser" method="post" name="registration" >
    <table>
        <tr>
            <td>First Name</td>
            <td>:<input type="text" name="firstName" value="" placeholder="First Name"
                        class="input_FirstName"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>:<input type="text" name="lastName" value="" placeholder="Last Name"
                        class="input_LastName"></td>
        </tr>
        <tr>
            <td>:Date Of Birth</td>
            <td><input id="dateOfBirth" value="" title="DOB" />
            </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>:<input type="radio" value="male" name="gender">Male
                <input type="radio" value="female" name="gender">Female</td>
        </tr>
        <tr>
            <td>userName</td>
            <td>:<input type="text" name="userName" value="" placeholder="UserName"
                        class="input_UserName"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td>:<input type="text" name="email" value="" placeholder="email"
                        class="input_Email"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td>:<input type="password" name="password" value="" placeholder="Password"
                        class="input_Password"></td>
        </tr>

        <tr>
            <td>Confirm Password</td>
            <td>:<input type="password" name="password" value="" placeholder="re-
                        Password" class="input_re-Password"></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="submit" onclick='validate()'>
            </td>
        </tr>
    </table>
</form>
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
    $(document).ready(function() {
        // create DatePicker from input HTML element
        $("#dateOfBirth").kendoDatePicker({
            value: new Date(),
            dateInput: true
        });
    });
</script>
</body>
</html>
