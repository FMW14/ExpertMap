<#import "parts/common.ftl" as c>

<@c.page>
<div>Список проблем</div>
    <#list problems as problem>
    <div>
        <b>${problem.name}</b>
        <a href="/businessInfo/problem/${problem.id}">edit</a>
        </div>
    <#else >
        No problems
    </#list>


<div>Список задач</div>
    <#list tasks as task>
<div>
    <b>${task.name}</b>
    <a href="/businessInfo/task/${task.id}">edit</a>
</div>
    <#else >
No tasks
    </#list>


</@c.page>