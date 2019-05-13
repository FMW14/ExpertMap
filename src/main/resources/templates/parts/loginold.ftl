<#--<#macro login path>-->
<#--<form action="${path}" method="post">-->
    <#--<div><label> User Name : <input type="text" name="username"/> </label></div>-->
    <#--<div><label> Password: <input type="password" name="password"/> </label></div>-->
    <#--<input type="hidden" name="_csrf" value="${_csrf.token}" />-->
    <#--<div><input type="submit" value="Sign In"/></div>-->
<#--</form>-->
<#--</#macro>-->

<#--<#macro logout>-->
<#--<form action="/logout" method="post">-->
    <#--<input type="hidden" name="_csrf" value="${_csrf.token}" />-->
    <#--&lt;#&ndash;<button class="btn btn-primary" type="submit"><#if user??>Sign Out<#else>Log in</#if></button>&ndash;&gt;-->
    <#--<button type="submit"><#if user??>Sign Out<#else>Log in</#if></button>-->
<#--</form>-->
<#--</#macro>-->