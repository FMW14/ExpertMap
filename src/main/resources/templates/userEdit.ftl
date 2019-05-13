<#import "parts/common.ftl" as c>

<@c.page>
<form action="/user" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group">
    <div><h5 name="username">Edit roles <br/>User: ${user.username}</h5></div>

    <#list roles as role>
    <div class="ml-4">
        <label><input type="checkbox" class="form-check-input" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} />${role}</label>
    </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
</form>
</@c.page>
