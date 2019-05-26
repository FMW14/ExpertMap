$(document).ready(function () {
    $("#problemList").on('change', function () {
        var val = $("#problemList").val();
        $.ajax({
            url : '/api/get_tasks',
            dataType: "json",
            data: { val : val },
            success : function (data) {
                $("#tasks tr").remove();
                var html = "<table data-toggle='table' class='table table-striped table-bordered'>";
                for (var i = 0; i < data.length; i++) {
                    html+="<tr>";
                    html+="<td data-width='80'>" + "<input type='checkbox' value=" + data[i].id + " style='width: 1.10rem !important;" +
                        "height: 1.10rem !important;'/>" + "</td>";
                    html+="<td>" + data[i].name + "</td>";
                    html+="</tr>";
                }
                html+="</table>";
                $("#tasks").html(html);
                $("#ts").css("visibility", "visible");
            },
            error : function () {
                alert("error get tasks");
            }
        })
    })
});