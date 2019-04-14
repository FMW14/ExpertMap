<#import "parts/common.ftl" as c>

<@c.page>
<a href="/">Main page</a>
<br/>
<a href="/businessInfo/sort">sort</a>

<p>
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
</p>


<p>
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
</p>

<p>
<div>Список инструментов</div>
    <#list tools as tool>
<div>
    <b>${tool.name}</b>
    <a href="/businessInfo/tool/edit/${tool.id}">edit</a>
    <a href="/businessInfo/tool/delete/${tool.id}">delete</a>
</div>
    <#else >
No tools
    </#list>
<a href="/businessInfo/tool/new/">Add new tool</a>
</p>

    ${message?if_exists}

</@c.page>