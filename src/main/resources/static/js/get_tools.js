$(document).ready(function () {
    $("#gettools").click(function () {
        var selected = new Array();
        $("input:checked").each(function() {
            selected.push($(this).val());
        });
        selected = JSON.stringify(selected);
        selected = JSON.parse(selected);
        $.ajax({
            url : '/api/get_tools',
            contentType: "application/json",
            dataType: "json",
            data: { selected : selected },
            success : function (data) {
                $("#tools tr").remove();
                var html =  "<table data-toggle='table' class='table table-striped table-bordered'>";
                for (var i = 0; i < data.length; i++) {
                    html+="<tr>";
                    html+="<td data-width='80'>" + "<select class='form-control' name =" + data[i].name + " >";

                    for (var z = 0; z < 6; z++) {
                        html+="<option value=";
                        html+= z;
                        html+=">";
                        html+= z;
                        html+= "</option>";
                    }
                    html+="</select>" + "</td>";
                    html+="<td>" + data[i].name + "</td>";
                    html+="</tr>";

                }
                html+="</table>" +
                    "<button type='submit' class='btn btn-primary mt-3'>Confirm</button>";
                $("#tools").html(html);
            },
            error : function () {
                alert("error get tools");
            }
        })
    })
});