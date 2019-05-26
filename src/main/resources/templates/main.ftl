<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<#--<script type="text/javascript" src="/js/123.js"></script>-->
<#--<div id="msg"></div>-->
    <h5 align="center">
    <#if known>
        Hello, ${name}
    <#else >
        Hello, guest
    </#if>
    </h5>

<a href="/login">Login page</a>

</@c.page>