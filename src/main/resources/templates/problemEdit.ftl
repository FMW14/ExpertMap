<#import "parts/common.ftl" as c>

<@c.page>
Edit problem

<form action="/businessInfo/problem/edit" method="post">
    <input type="text" name="problemName" value="${problem.name?if_exists}" placeholder="problem name"/>
    <#list probTasks as task>
    <#--<b>${task.name}</b>-->
    <div>
        <label><input type="checkbox" name="${task.id}" ${problem.tasks?if_exists?seq_contains(task)?string("checked", "")} />${task.name}</label>
    </div>
    <#else >
        No tasks
    </#list>
    <input type="hidden" value="${problem.id?if_exists}" name="problemId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Save</button>
</form>
</@c.page>