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
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
          href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
    <title>Add Event</title>

</head>
<body>
<div class="form">
    <h1 style="color: white">Event Info</h1>

    <form action="${pageContext.request.contextPath }/actionController?action=add" method="post" name="add">
        <div class="top-row">
            <div class="field-wrap">
                <label>
                    Task Description<span class="req">*</span>
                </label>
            </div>
            <div class="field-wrap">
                <input type="text" name="taskName" class="input_TaskName" required autocomplete="off"/>
            </div>
        </div>
        <div class="top-row">
            <div class="field-wrap">
                <label>
                    Start Time<span class="req">*</span>
                </label>
            </div>
            <div class="field-wrap">
                <input id="startTime" name="startTime" type="text"/>
            </div>
        </div>
        <div class="top-row">
            <div class="field-wrap">
                <label>
                    End Time<span class="req">*</span>
                </label>
            </div>
            <div class="field-wrap">
                <input id="endTime" name="endTime" type="text" required autocomplete="off"/>
            </div>
        </div>
        </br>
        <button class="button button-block"/>
        Add</button>
    </form>
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
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
<%--date picker--%>
<script type="text/javascript"
        src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
</script>
<script type="text/javascript"
        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
</script>
<script type="text/javascript">
    $(function () {
        $('#startTime').datetimepicker({
            format: 'yyyy-MM-dd hh:mm:ss'
        });
        $('#endTime').datetimepicker({
            format: 'yyyy-MM-dd hh:mm:ss'
        });
    });
</script>
</body>
</html>
