<#import "parts/common.ftl" as c>

<@c.page>
Edit task

<form action="/businessInfo/task/edit" method="post">
    <input type="text" name="taskName" value="${task.name?if_exists}" />
    <#list taskTools as tool>
    <#--<b>${tool.name}</b>-->
    <div>
        <label><input type="checkbox" name="${tool.id}" ${task.tools?if_exists?seq_contains(tool)?string("checked", "")} />${tool.name}</label>
    </div>
    <#else >
        No tools
    </#list>
    <input type="hidden" value="${task.id?if_exists}" name="taskId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Save</button>
</form>
</@c.page>