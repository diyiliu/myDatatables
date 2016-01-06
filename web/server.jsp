<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="./css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="./css/dataTables.bootstrap.css">
    <title>Server dynamic</title>
</head>
<body>
<div class="container">
    <table id="example" class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>班级</th>
            <th>教师</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/jquery.dataTables.js"></script>
<script type="text/javascript" src="./js/dataTables.bootstrap.js"></script>
<script type="text/javascript">

    $.extend(true, $.fn.dataTable.defaults, {
        "bPaginate": true,
        "bLengthChange": false,
        "bFilter": false,
        "bSort": false,
        "bInfo": false,
        "bAutoWidth": true
    });

    $(document).ready(function () {
        var table = $('#example').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "<%=path%>/student",
                "type": "POST"
            },
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "age"},
                {"data": "grade"},
                {"data": "teacher"},
                {"data": null}
            ],
            "columnDefs": [
                {
                    "targets": [2],
                    "visible": false,
                    "searchable": false
                }, {
                    "targets": -1,
                    "data": null,
                    "defaultContent": "<button>Click!</button>"
                }]
        });

        $('#example tbody').on('click', 'button', function () {
            var data = table.row($(this).parents('tr')).data();
            alert(data["name"] + " is " + data["age"] + " years old!");
        });
    });
</script>
</body>
</html>
