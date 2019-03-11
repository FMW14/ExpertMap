<#import "parts/common.ftl" as c>

<@c.page>
Edit task

<form action="/businessInfo" method="post">
    <input type="text" name="taskName" value="${task.name}" />
    <#list taskTools as tool>
    <#--<b>${tool.name}</b>-->
    <div>
        <label><input type="checkbox" name="${tool}" ${task.tools?seq_contains(tool)?string("checked", "")} />${tool.name}</label>
    </div>
    </#list>
    <input type="hidden" value="${task.id}" name="taskId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Save</button>
</form>
</@c.page>