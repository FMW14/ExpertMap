<#import "parts/common.ftl" as c>

<@c.page>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#--<button type="submit"><#if user??>Sign Out<#else>Log in</#if></button>-->
    <button type="submit">Sign Out</button>
</form>

<#--<div>-->
    <#--<form action="/logout" method="post">-->
        <#--<input type="submit" value="Sign Out"/>-->
        <#--<input type="hidden" name="_csrf" value="{{_csrf.token}}" />-->
    <#--</form>-->
<#--</div>-->


<#--<div align="center">Hello</div>-->
<div>Hello</div>
    <div>
        <a href="/login">Login page</a>
        <a href="/list">Problems list</a>
        <a href="/businessInfo">Business Info</a>
        <a href="/expertList">Expert list</a>
        <span><a href="/user">Userlist</a></span>
    </div>
</@c.page>