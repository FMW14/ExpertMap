<#import "parts/common.ftl" as c>
<#--<#import "parts/loginold.ftl" as l>-->

<@c.page>
<#--<script src="https://cdn.jsdelivr.net/npm/table-to-json@0.13.0/lib/jquery.tabletojson.min.js"-->
        <#--integrity="sha256-AqDz23QC5g2yyhRaZcEGhMMZwQnp8fC6sCZpf+e7pnw="-->
        <#--crossorigin="anonymous">-->
<#--</script>-->
<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/get_tasks.js"></script>
<script type="text/javascript" src="/js/get_tools.js"></script>

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

    </div>

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

<#--<script>-->
    <#--$(document).ready(function () {-->
        <#--$("#problemList").on('change', function () {-->
            <#--var val = $("#problemList").val();-->
            <#--$.ajax({-->
                <#--url : '/api/get_tasks',-->
                <#--dataType: "json",-->
                <#--data: { val : val },-->
                <#--success : function (data) {-->
                    <#--$("#tasks tr").remove();-->
                    <#--var html = "<table data-toggle='table' class='table table-striped table-bordered'>";-->
                    <#--for (var i = 0; i < data.length; i++) {-->
                        <#--html+="<tr>";-->
                        <#--html+="<td data-width='80'>" + "<input type='checkbox' value=" + data[i].id + " style='width: 1.25rem !important;" +-->
                                <#--"height: 1.25rem !important;'/>" + "</td>";-->
                        <#--html+="<td>" + data[i].name + "</td>";-->
                        <#--html+="</tr>";-->
                    <#--}-->
                    <#--html+="</table>";-->
                    <#--$("#tasks").html(html);-->
                    <#--$("#ts").css("visibility", "visible");-->
                <#--},-->
                <#--error : function () {-->
                    <#--alert("error get tasks");-->
                <#--}-->

            <#--})-->
        <#--})-->

    <#--});-->
<#--</script>-->

<#--<script>-->
    <#--$(document).ready(function () {-->
        <#--$("#gettools").click(function () {-->
            <#--var selected = new Array();-->
            <#--$("input:checked").each(function() {-->
                <#--selected.push($(this).val());-->
            <#--});-->
            <#--//------???????????-->
            <#--selected = JSON.stringify(selected);-->
            <#--selected = JSON.parse(selected);-->
            <#--$.ajax({-->
                <#--url : '/api/get_tools',-->
                <#--contentType: "application/json",-->
                <#--dataType: "json",-->
                <#--data: { selected : selected },-->
                <#--success : function (data) {-->
                    <#--$("#tools tr").remove();-->
                    <#--var html =  "<table data-toggle='table' class='table table-striped table-bordered'>";-->
                    <#--for (var i = 0; i < data.length; i++) {-->
                        <#--html+="<tr>";-->
                        <#--html+="<td data-width='80'>" + "<select class='form-control' name =" + data[i].name + " >";-->

                        <#--for (var z = 0; z < 6; z++) {-->
                            <#--html+="<option value=";-->
                            <#--html+= z;-->
                            <#--html+=">";-->
                            <#--html+= z;-->
                            <#--html+= "</option>";-->
                        <#--}-->
                        <#--html+="</select>" + "</td>";-->
                        <#--html+="<td>" + data[i].name + "</td>";-->
                        <#--html+="</tr>";-->

                    <#--}-->
                    <#--html+="</table>" +-->
                            <#--"<button type='submit' class='btn btn-primary mt-3'>Confirm</button>";-->
                    <#--$("#tools").html(html);-->
                <#--},-->
                <#--error : function () {-->
                    <#--alert("error get tools");-->
                <#--}-->
            <#--})-->
        <#--})-->
    <#--});-->
<#--</script>-->

</@c.page>