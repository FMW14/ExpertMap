<#import "parts/common.ftl" as c>
<#--<#import "parts/loginold.ftl" as l>-->

<@c.page>
<#--<script src="https://cdn.jsdelivr.net/npm/table-to-json@0.13.0/lib/jquery.tabletojson.min.js"-->
        <#--integrity="sha256-AqDz23QC5g2yyhRaZcEGhMMZwQnp8fC6sCZpf+e7pnw="-->
        <#--crossorigin="anonymous">-->
<#--</script>-->
<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">

<#--<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>-->
<#--<script src="https://github.com/lightswitch05/table-to-json/blob/master/src/jquery.tabletojson.js"></script>-->

<div>Выбор проблемы:</div>
    <div>
        <select id="problemList" name="problemList" >
            <option value="" selected disabled>Select a problem</option>
                <#list problems as problem>
                    <option value="${problem.id}">${problem.name}</option>
                </#list>
        </select>
    </div>
</p>

<div id="ts" style="visibility: hidden">Выбор задач:</div>
    <div>
    <#--<#list tasks as task>-->
        <#--<div>-->
            <#--&lt;#&ndash;<label><input type="checkbox" name="${task.id}" ${task.name?seq_contains(task)?string("checked", "")} />${task}</label>&ndash;&gt;-->
        <#--</div>-->
        <#--<select id="taskList" name="taskList" >-->
                <#--<#list tasks as task>-->
                    <#--<option value="${task.id}">${task.name}</option>-->
                <#--</#list>-->
        <#--</select>-->
    </div>

<#--<form action="/solution" method="post" id="tf">-->

<#--<table id="tasks"-->
       <#--data-toggle="table"-->
       <#--class="table table-striped table-bordered"-->
<#-->-->

    <#--<tr>-->
        <#--<th>Name</th>-->
    <#--</tr>-->
    <#--<#list tasks as task>-->
        <#--<tr>-->
            <#--<td class="name">${task.name?capitalize}</td>-->
            <#--<td><div location="button-${task.id}" /></td>-->
        <#--</tr>-->
    <#--</#list>-->

</table>
<div id="tasks"></div>
<button id="gettools">Get tools</button>
<div class="form-group">
    <form action="/solution/result" method='get'>
        <input type="hidden" value="${_csrf.token}" name="_csrf" />
        <div id="tools"></div>
        <#--<button type='submit' class="btn btn-primary mt-3">Confirm</button>-->
    </form>
</div>


<#--<button id="getexperts">Get experts</button>-->
<#--<button type="submit" class="btn btn-primary mr-3">Go</button>-->
<#--</form>-->

<script>
    // $(document).ready(function () {
    //     $("#gettools").click(function () {
    //         // alert("clicked");
    //         var val = $("#problemList").val();
    //         $.ajax({
    //             url : '/get_tasks',
    //             data: { val : val },
    //             success : function (data) {
    //                 $("#results").html(data);
    //             },
    //             error : function () {
    //                 alert("error");
    //             }
    //
    //         })
    //     })
    //
    // });

    $(document).ready(function () {
        $("#problemList").on('change', function () {
        // $("#gettools").click(function () {
            // alert("clicked");
            var val = $("#problemList").val();
            $.ajax({
                url : '/api/get_tasks',
                dataType: "json",
                data: { val : val },
                success : function (data) {
                    // var a = JSON.stringify(data);
                    // var parsed = JSON.parse(a);

                    // alert(a);
                    // console.log(a);


                    $("#tasks tr").remove();
                    var html = "<table data-toggle='table' class='table table-striped table-bordered'>";
                    // console.log(parsed.length);
                    for (var i = 0; i < data.length; i++) {
                        html+="<tr>";
                        html+="<td data-width='80'>" + "<input type='checkbox' value=" + data[i].id + " style='width: 1.25rem !important;" +
                                "height: 1.25rem !important;'/>" + "</td>";
                                // +rows[i].name+"</td>";
                        html+="<td>" + data[i].name + "</td>";
                        html+="</tr>";

                    }
                    html+="</table>";
                    $("#tasks").html(html);


                    // $.each(parsed, function(i, item) {
                    //     var $tr = $('<tr>').append(
                    //             // $('<td>')
                    //             $("<tr>" +
                    //                     "<td>" +
                    //                     "<input type='checkbox' name=item.id class=\"form-check-input\" />" +
                    //                     "</td>" +
                    //                     "</tr>"),
                    //             // $('<td>').text(item.id),
                    //             $('<td>').text(item.name)
                    //     ).appendTo('#tasks');
                    // });
                    $("#ts").css("visibility", "visible");
                },
                error : function () {
                    alert("error get tasks");
                }

            })
        })

    });
</script>

<#--<script>-->
    <#--$('#convert-table').click( function() {-->
        <#--var table = $('#example-table').tableToJSON(); // Convert the table into a javascript object-->
        <#--console.log(table);-->
        <#--alert(JSON.stringify(table));-->
    <#--});-->
<#--</script>-->

<script>
    $(document).ready(function () {
        // $("#ts").on('change', function () {
            $("#gettools").click(function () {
                // var array =  $("input[name='Question1']:checked").map(function(){
                //     return this.value;
                // }).get()
                // console.log(array);

                //-------------------------------------------!
                // var test = $('input:checked');
                // for(var i=0; i<test.length; i++) {
                //     var keys = Object.keys(test[i]);
                //
                //
                //     // test[i].get();
                //     // console.log(keys);
                // }

                var selected = new Array();
                $("input:checked").each(function() {
                    selected.push($(this).val());
                });

                selected = JSON.stringify(selected);
                selected = JSON.parse(selected);
                // console.log(selected);

                // console.log(test);
                // console.log($('input:checked'));

                // var table = $('#tasks').tableToJSON(); // Convert the table into a javascript object
                // var b = JSON.stringify(makeJsonFromTable('tasks'));
                // console.log(b);


                // console.log(table);
                // alert(JSON.stringify(table));

            $.ajax({
                url : '/api/get_tools',
                contentType: "application/json",
                dataType: "json",
                data: { selected : selected },
                success : function (data) {
                    // console.log(typeof data);
                    // console.log(data);
                    // console.log("data: "+ data.length);
                    // console.log(data[0].name);
                    // console.log(data.length);

                    // var a = JSON.stringify(data);
                    // console.log(a);
                    // console.log("A: "+ a.length);
                    // var parsed = JSON.parse(data);
                    // console.log(parsed);

                    $("#tools tr").remove();
                    // var html = "<form action='/solution/confirm' method='post'> " +
                    var html =  "<table data-toggle='table' class='table table-striped table-bordered'>";
                    // console.log(parsed.length);
                    for (var i = 0; i < data.length; i++) {
                        html+="<tr>";
                    <#--<select id=${rt.toolname} name=${rt.toolname} >-->
                        html+="<td data-width='80'>" + "<select class='form-control' name =" + data[i].name + " >";

                        for (var z = 0; z < 6; z++) {
                            html+="<option value=";
                            html+= z;
                            html+=">";
                            html+= z;
                            html+= "</option>";
                        }

                        // html+="<option value='0'>0</option>";
                        // html+="<option value='1'>1</option>";
                        // html+="<option value='2'>2</option>";
                        // html+="<option value='3'>3</option>";
                        // html+="<option value='4'>5</option>";
                        // html+="<option value='4'>5</option>";
                        html+="</select>" + "</td>";
                        // +rows[i].name+"</td>";
                        html+="<td>" + data[i].name + "</td>";
                        html+="</tr>";

                    }
                    html+="</table>" +
                "<button type='submit' class='btn btn-primary mt-3'>Confirm</button>";
                            // "</form>";
                    $("#tools").html(html);
                },
                error : function () {
                    alert("error get tools");
                }
            })
        })
    });
</script>


<#--<p id="results">Тут будет выведен результат</p>-->


</@c.page>