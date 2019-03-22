<#import "parts/common.ftl" as c>

<@c.page>
<div>Список проблем</div>
    <#list problems as problem>
    <div>
        <b>${problem.name}</b>
        <a href="/businessInfo/problem/edit/${problem.id}">edit</a>
        <a href="/businessInfo/problem/delete/${problem.id}">delete</a>
        <#--<form action="/businessInfo/problem/delete/${problem.id}" method="post">-->
            <#--<input type="hidden" value="${problem.id}" name="problemId" />-->
            <#--<button type="submit">Delete</button>-->
        <#--</form>-->
        </div>
    <#else >
        No problems
    </#list>
<a href="/businessInfo/problem/new/">Add new problem</a>

<div>Список задач</div>
    <#list tasks as task>
<div>
    <b>${task.name}</b>
    <a href="/businessInfo/task/edit/${task.id}">edit</a>
    <a href="/businessInfo/task/delete/${task.id}">delete</a>
</div>
    <#else >
No tasks
    </#list>
<a href="/businessInfo/task/new/">Add new task</a>

    ${message?if_exists}

</@c.page>