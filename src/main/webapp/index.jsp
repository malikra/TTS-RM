<!DOCTYPE html>
<html>
<head>
    <base href="https://demos.telerik.com/kendo-ui/datetimepicker/index">
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.117/styles/kendo.material.mobile.min.css" />

    <script src="https://kendo.cdn.telerik.com/2018.1.117/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2018.1.117/js/kendo.all.min.js"></script>


</head>
<body>

<div id="example">

    <div class="demo-section k-content">
        <h4>Remind me on</h4>
        <input id="datetimepicker" title="datetimepicker" style="width: 40%;" />
    </div>

    <script>
        $(document).ready(function () {
            // create DateTimePicker from input HTML element
            $("#datetimepicker").kendoDateTimePicker({
                value: new Date(),
                dateInput: true
            });
        });
        $('#datetimepicker').change(function() {
            $('#hh').val($(this).val());
        });
    </script>

</div>


</body>
</html>