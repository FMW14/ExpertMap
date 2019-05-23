<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Expert Team Builder</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#--<li class="nav-item active">-->
                <#--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>-->
            <#--</li>-->
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


            <#--<li class="nav-item dropdown">-->
                <#--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">-->
                    <#--Dropdown-->
                <#--</a>-->
                <#--<div class="dropdown-menu" aria-labelledby="navbarDropdown">-->
                    <#--<a class="dropdown-item" href="#">Action</a>-->
                    <#--<a class="dropdown-item" href="#">Another action</a>-->
                    <#--<div class="dropdown-divider"></div>-->
                    <#--<a class="dropdown-item" href="#">Something else here</a>-->
                <#--</div>-->
            <#--</li>-->
            <#--<li class="nav-item">-->
                <#--<a class="nav-link disabled" href="#">Disabled</a>-->
            <#--</li>-->
        </ul>

        <div class="navbar-text mr-3"><#if curuser??>${name}</#if></div>
        <#--<form class="form-inline my-2 my-lg-0">-->
            <#--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
            <#--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
        <#--</form>-->
        <#--<@l.logout />-->

        <#if known>
            <div class="form-inline">
                <@l.logout/>
            </div>
        <#else>
        <a href="/login" class="btn btn-outline-primary">Sign In</a>
        </#if>﻿
    </div>
</nav>