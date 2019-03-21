<#import "parts/common.ftl" as c>

<@c.page>
<div>Список проблем</div>
    <#list problems as problem>
    <div>
        <b>${problem.name}</b>
        <a href="/businessInfo/problem/edit/${problem.id}">edit</a>
        </div>
    <#else >
        No problems
    </#list>
<a href="/businessInfo/problem/new/">Add new problem</a>

<div>Список задач</div>
    <#list tasks as task>
<div>
    <b>${task.name}</b>
    <a href="/businessInfo/task/${task.id}">edit</a>
</div>
    <#else >
No tasks
    </#list>

    ${message?if_exists}

</@c.page>