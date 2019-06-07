$(document).ready(function () {
    $("#problemList").on('change', function () {
        var val = $("#problemList").val();
        $.ajax({
            url : '/api/get_tasks',
            dataType: "json",
            data: { val : val },
            success : function (data) {
                $("#tasks tr").remove();
                var html = "<table data-toggle='table' class=' table table-sm table-bordered'>";
                html+= "<thead><tr><th scope='col' data-checkbox='true' style='width: 5%'></th>";
                html+="<th scope='col'>Task title</th>";
                html+="</tr></thead><tbody>";
                for (var i = 0; i < data.length; i++) {
                    html+="<tr>";
                    html+="<td scope='row' align='center'>" + "<span class='align-middle'>" +
                        "<input type='checkbox' checked value=" + data[i].id +
                        " style='width: 1.10rem !important;" +
                        "height: 1.10rem !important;'/>" + "</span></td>";
                    html+="<td>" + data[i].name + "</td>";
                    html+="</tr>";
                }
                html+="</tbody></table>";
                $("#tasks").html(html);
                $("#gettools").css("visibility", "visible");
            },
            error : function () {
                alert("error get tasks");
            }
        })
    })
});

