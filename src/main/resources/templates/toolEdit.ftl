<#import "parts/common.ftl" as c>

<@c.page>
Edit tool

<form action="/businessInfo/tool/edit" method="post">
    <input type="text" name="toolName" value="${tool.name?if_exists}" />

    <input type="hidden" value="${tool.id?if_exists}" name="toolId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Save</button>
</form>
</@c.page>