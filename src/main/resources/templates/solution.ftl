<#import "parts/common.ftl" as c>
<#--<#import "parts/loginold.ftl" as l>-->

<@c.page>
<#--<script src="https://cdn.jsdelivr.net/npm/table-to-json@0.13.0/lib/jquery.tabletojson.min.js"-->
        <#--integrity="sha256-AqDz23QC5g2yyhRaZcEGhMMZwQnp8fC6sCZpf+e7pnw="-->
        <#--crossorigin="anonymous">-->
<#--</script>-->
    <!--Bootstrap-TABLE-->
    <#--<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">-->
    <#--<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>-->
<#--<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">-->
<script type="text/javascript" src="/js/get_tasks.js"></script>
<script type="text/javascript" src="/js/get_tools.js"></script>

<#--<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>-->
<#--<script src="https://github.com/lightswitch05/table-to-json/blob/master/src/jquery.tabletojson.js"></script>-->

<#--<h5>Выбор проблемы:</h5>-->
    <div>
        <select class="form-control text-primary" id="problemList" name="problemList" >
            <option value="" selected disabled>Select a problem</option>
                <#list problems as problem>
                    <option class="text-dark" value="${problem.id}">${problem.name}</option>
                </#list>
        </select>
    </div>
</p>

<#--<div id="ts" style="visibility: hidden">Выбор задач:</div>-->


<div id="tasks"></div>

<div class="float-left mb-3">
<button class='btn btn-primary mt-0 ' id="gettools" style="visibility: hidden">Get tools</button>
</div>

<div class="form-group">
    <form action="/solution/result" method='get'>
        <input type="hidden" value="${_csrf.token}" name="_csrf" />
        <div id="tools"></div>
        <#--<button type='submit' class="btn btn-primary mt-3">Confirm</button>-->
    </form>
</div>
</@c.page>