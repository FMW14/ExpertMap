<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>

<#--<a href="/user/add" class="btn btn-outline-primary">Add user</a>-->

<div>
    <div class="form-inline float-left mt-2"><h4>List of users</h4></div>

    <div class="float-right mb-3">
        <a href="/user/add" class="btn btn-primary ml-5 "
           <#--style="width: 180px; text-align: center"-->
        >Add new user</a>
    </div>
</div>
<div>
<table class="table table-striped table-bordered"
       data-toggle="table">
    <thead class="thead-light">
    <tr>
        <th>Name</th>
        <th>Roles</th>
        <th scope="col" ></th>
        <th scope="col" ></th>
    </tr>

    </thead>
    <tbody>
    <#list users as user>
    <#if user.username!="admin">
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>,</#list></td>
        <td>
            <a href="/user/${user.id}" class="btn btn-outline-primary btn-sm">Edit</a>
        </td>
        <td>
            <a href="/user/delete/${user.id}" class="btn btn-outline-danger btn-sm">Delete</a>
                <#--<input type="hidden" value="${_csrf.token}" name="_csrf"/>-->
        <#--<a href="/user/${user.id}">edit</a>-->
        </td>
    </tr>
    <#else >
        <#if isAdmin>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>,</#list></td>
                <td>
                    <a href="/user/${user.id}" class="btn btn-outline-primary btn-sm">Edit</a>
                </td>
                <td>
                    <a href="/user/delete/${user.id}" class="btn btn-outline-danger btn-sm">Delete</a>
                </td>
            </tr>
        </#if>
    </#if>
    </#list>
    </tbody>


</table>
</div>
<#--<button type="button">Save</button>-->
</@c.page>