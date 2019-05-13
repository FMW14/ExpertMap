<#import "parts/common.ftl" as c>
<#import "parts/loginold.ftl" as l>

<@c.page>
<br/>

<p>
<div>Выбор проблемы:</div>
    <div>
        <select id="problemList" name="problemList" >
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

<table id="tasks" >
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
                    var a = JSON.stringify(data);
                    // console.log(a);
                    var parsed = JSON.parse(a);

                    $("#tasks tr").remove();
                    $.each(parsed, function(i, item) {
                        var $tr = $('<tr>').append(
                                // $('<td>')
                                $("<tr><td><input type='checkbox' name=item.id class=\"form-check-input\" /></td></tr>"),
                                // $('<td>').text(item.id),
                                $('<td>').text(item.name)
                        ).appendTo('#tasks');
                        // console.log($tr.wrap('<p>').html());
                    });
                    $("#ts").css("visibility", "visible");
                },
                error : function () {
                    alert("error");
                }

            })
        })

    });
</script>


<#--<p id="results">Тут будет выведен результат</p>-->
    <#--<button id="gettools">Get tasks</button>-->

</@c.page>