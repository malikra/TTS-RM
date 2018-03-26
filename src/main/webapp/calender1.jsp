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
    <script src='js/jquery.min.js'></script>
    <script src='js/moment.min.js'></script>
    <script src='js/fullcalendar.js'></script>

    <script>
        /*$(document).ready(function() {
            $('#calendar').fullCalendar({
                theme: true,
                editable: true
                // events: "/createUser"
            });

        });*/

        var ourRequest = new XMLHttpRequest();

         $(document).ready(function() {

             var calendar = $('#calendar').fullCalendar({
                 header: {
                     left: 'prev,next today',
                     center: 'title',
                     right: 'month,agendaWeek,agendaDay'
                 },
                 selectable: true,
                 selectHelper: true,

                 select: function(start, end, allDay) {
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
                 },
                 editable: true,

                 eventSources: [
                     {
                         url: '/calendarDetails',
                         type: 'GET',
                         data: {
                             start: 'start',
                             end: 'end',
                             id: 'id',
                             title: 'title',
                             allDay: 'allDay'
                         },
                         error: function () {
                             alert('there was an error while fetching events!');
                         }
                     }
                 ]
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
    <div id="calendar"></div>
    <%--<div id="eventContent" title="Event Details" style="display:none;">
        Start: <span id="startTime"></span><br>
        End: <span id="endTime"></span><br><br>
        <p id="eventInfo"></p>
        <p><strong><a id="eventLink" href="" target="_blank">Read More</a></strong></p>
    </div>--%>
</head>
<body>

</body>
</html>
