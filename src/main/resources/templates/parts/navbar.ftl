<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Expert Team Builder</a>
    <button class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if known>
            <li class="nav-item">
                <a class="nav-link" href="/solution">Solution</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/businessInfo">Business Info</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/expertList">Expert list</a>
            </li>
            </#if>

            <#if isMod>
            <li class="nav-item">
                <a class="nav-link" href="/user">Userlist</a>
            </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3"><#if curuser??>${name}</#if></div>

        <#if known>
            <div class="form-inline">
                <@l.logout/>
            </div>
        <#else>
        <a href="/login" class="btn btn-outline-primary">Sign In</a>
        </#if>﻿
    </div>
</nav>

