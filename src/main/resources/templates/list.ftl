<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>
    <form method="post" action="addProblem">
        <input type="text" name="name" placeholder="Enter problem">
        <button type="submit">Add</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>

<div>Список проблем</div>
<#list problems as problem>
<div>
    <b>${problem.id}</b>
    <b>${problem.name}</b>
</div>
<#else >
No problems
</#list>

<div>
    <form method="post" action="addTask">
        <input type="text" name="name" placeholder="Enter task">
        <button type="submit">Add</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>
<div>Список задач</div>
<#list tasks as task>
<div>
    <b>${task.id}</b>
    <b>${task.name}</b>
</div>
    <#else >
No tasks
</#list>


<#--{{#tasks}}-->
    <#--<div align="center">-->
        <#--<b>{{id}}</b>-->
        <#--<b>{{name}}</b>-->
    <#--</div>-->
<#--{{/tasks}}-->
<!--<div align="center">-->
    <!--<form method="post" action="filter">-->
        <!--<input type="text" name="filter" placeholder="Enter filter">-->
        <!--<button type="submit">Search</button>-->
    <!--</form>-->
<!--</div>-->
</@c.page>