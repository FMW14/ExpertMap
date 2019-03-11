<#import "parts/common.ftl" as c>

<@c.page>
Edit problem

<form action="/businessInfo" method="post">
    <input type="text" name="problemName" value="${problem.name}" />
    <#list probTasks as task>
    <#--<b>${task.name}</b>-->
    <div>
        <label><input type="checkbox" name="${task}" ${problem.tasks?seq_contains(task)?string("checked", "")} />${task.name}</label>
    </div>
    </#list>
    <input type="hidden" value="${problem.id}" name="problemId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Save</button>
</form>
</@c.page>