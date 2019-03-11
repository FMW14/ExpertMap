<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    </form>
</div>
<div align="center">Hello</div>
    <div align="center">
        <a href="/login">Login page</a>
        <a href="/list">Problems list</a>
        <a href="/businessInfo">Admin list</a>
        <span><a href="/user">Userlist</a></span>
    </div>
</@c.page>