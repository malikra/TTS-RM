<%--
  Created by IntelliJ IDEA.
  User: rashidmalik
  Date: 3/19/18
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Calendar</title>
    <link rel='stylesheet' href='css/fullcalendar.css'/>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
        .form {
            max-width: 900px;
            color: #1ab188;
        }
    </style>
    <%--Materealize--%>
    <%--<div id="eventContent" title="Event Details" style="display:none;">
        Start: <span id="startTime"></span><br>
        End: <span id="endTime"></span><br><br>
        <p id="eventInfo"></p>
        <p><strong><a id="eventLink" href="" target="_blank">Read More</a></strong></p>
    </div>--%>
</head>
<body>
<script src='js/jquery.min.js'></script>
<script src='js/moment.min.js'></script>
<script src='js/fullcalendar.js'></script>
<%--Materealize--%>
<script src="js/index.js"></script>
<script>
    var ourRequest = new XMLHttpRequest();

    $(document).ready(function() {

        var calendar = $('#calendar').fullCalendar({
            customButtons: {
                addEventButton: {
                    text: 'Add Event',
                    click: function() {
                        window.location = "${pageContext.request.contextPath }/calanderController?action=add";
                    }
                },
                EditEventButton: {
                    text: 'Edit event',
                    click: function() {
                        window.location = "${pageContext.request.contextPath }/calanderController";
                    }
                },
                HomeButton: {
                    text: 'Sign out',
                    click: function() {
                        window.location = "${pageContext.request.contextPath }/signOutController";
                    }
                }
            },

            header: {
                left : 'prev,next today addEventButton',
                center : 'title',
                right : 'EditEventButton listDay,listWeek,month'
            },

            views : {

                listDay : {
                    buttonText : 'list day'
                },
                listWeek : {
                    buttonText : 'list week'
                }
            },
            /*selectable: true,
            selectHelper: true,*/

            /*select: function(start, end, allDay) {
                var title = prompt('Event Title:');
                var start = prompt('Event Start Time:');
                var end = prompt('Event End Time:');

                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },*/

            defaultView : 'month',
            defaultDate : $('#calendar').fullCalendar('today'),
            navLinks : true, // can click day/week names to navigate views
            //editable : true,
            eventLimit : true,
            events : '${pageContext.request.contextPath }/eventController',
            color : 'yellow',
            textColor : 'orange',
            footer: {
                right : 'HomeButton'
            }

        });
    });
    /* $(document).ready(function () {
         $('#eventContent').fullCalendar({
             events: source,
             header: {
                 left: '',
                 center: 'prev title next',
                 right: ''
             },
             eventRender: function (event, element) {
                 element.attr('href', 'javascript:void(0);');
                 element.click(function () {
                     $("#startTime").html(moment(event.start).format('MMMM Do YYYY, h:mm:ss a');
                     $("#endTime").html(moment(event.end).format('MMMM Do YYYY, h:mm:ss a'));
                     $("#eventInfo").html(event.description);
                     $("#eventLink").attr('href', event.url);
                     $("#eventContent").dialog({modal: true, title: event.title, width: 350});
                 });
             }
         });
     });*/
</script>
<div class="form">
<div id="calendar" class="calendar"></div>
</div>
</body>
</html>
