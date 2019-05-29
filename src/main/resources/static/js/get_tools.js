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
                var html =  "<table data-toggle='table' class='table table-sm table-bordered'>";
                for (var i = 0; i < data.length; i++) {
                    html+="<tr>";
                    html+="<td style='width: 5%' data-align='center'>"  + "<select class='form-control-sm' name =" + data[i].name + " >";

                    for (var z = 0; z < 6; z++) {
                        html+="<option value=";
                        html+= z;
                        html+=">";
                        html+= z;
                        html+= "</option>";
                    }
                    html+="</select>" + "</td>";
                    html+="<td><span class='align-middle'>" + data[i].name + "</span></td>";
                    html+="</tr>";

                }
                html+="</table>";
                    // "<button type='submit' class='btn btn-primary mt-0'>Confirm</button>";
                $("#tools").html(html);
                $("#confirm").css("visibility", "visible");
            },
            error : function () {
                alert("error get tools");
            }
        })
    })
});