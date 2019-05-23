<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    curuser = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = curuser.getUsername()
    isAdmin = curuser.isAdmin()
    isMod = curuser.isMod()
    isMod2 = curuser.isMod2()
    currentUserId = curuser.getId()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isMod = false
    isMod2 = false
    currentUserId = -1
    >
</#if>