<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <div class="form-inline float-left mt-2"><h4>Problems</h4></div>

    <#if isMod>
    <div class="float-right mb-3">
        <a href="/businessInfo/problem/edit/" class="btn btn-primary ml-5 " style="width: 180px; text-align: center">Add new problem</a>
    </div>
    </#if>
</div>
<#--style="width: 100px; text-align: center"-->

<#--<div class="float-right form-inline"><a href="/businessInfo/problem/new/" class="btn btn-primary ml-5 ">Add new problem</a></div>-->
<div class="mt-3 mb-3">
    <table class="table table-striped table-bordered table-hover"
            data-toggle="table">
        <thead class="thead-light">
        <tr>
            <th scope="col" data-sortable="true">Title</th>
            <th scope="col" data-sortable="true" data-width="60">Type</th>
            <th scope="col" data-width="80" data-align="center" >Edit</th>
            <th scope="col" data-width="100" data-align="center" >Delete</th>
        </tr>
        </thead>
        <tbody>
    <#list problems as problem>
    <tr>
        <td scope="row">
            ${problem.name}
        </td>
        <td  scope="row">
            <#if problem.type == true>
                Internal
            <#else>
                External
            </#if>
        </td>

        <td scope="row" align="center">
            <a href="/businessInfo/problem/edit/${problem.id}" class="btn btn-outline-primary btn-sm" >Edit</a>
        </td>

        <td scope="row" align="center">
            <a href="/businessInfo/problem/delete/${problem.id}" class="btn btn-outline-danger btn-sm">Delete</a>
        </td>

    </tr>
    </#list>
        </tbody>
    </table>
</div>
    <#--<#list problems as problem>-->
    <#--<div>-->
        <#--<b>${problem.name}</b>-->
        <#--<a href="/businessInfo/problem/edit/${problem.id}">edit</a>-->
        <#--<a href="/businessInfo/problem/delete/${problem.id}">delete</a>-->

        <#--&lt;#&ndash;<form action="/businessInfo/problem/delete/${problem.id}" method="post">&ndash;&gt;-->
            <#--&lt;#&ndash;<input type="hidden" value="${problem.id}" name="problemId" />&ndash;&gt;-->
            <#--&lt;#&ndash;<button type="submit">Delete</button>&ndash;&gt;-->
        <#--&lt;#&ndash;</form>&ndash;&gt;-->
        <#--</div>-->
    <#--<#else >-->
        <#--No problems-->
    <#--</#list>-->

<#--<div class="form-inline">-->
    <#--<h5>Tasks</h5>-->
    <#--<a href="/businessInfo/task/new/" class="btn btn-primary ml-5">Add new task</a>-->
<#--</div>-->

<div>
    <div class="form-inline float-left mt-2"><h4>Tasks</h4></div>
    <#if isMod>
    <div class="float-right mb-3">
        <a href="/businessInfo/task/edit/" class="btn btn-primary ml-5" style="width: 180px; text-align: center">Add new task</a>
    </div>
    </#if>
</div>

<div class="mt-3 mb-3">
    <table
            <#--class="table table-striped table-bordered table-hover"-->
            data-toggle="table"
    >
        <thead class="thead-light">
        <tr>
            <th scope="col" data-sortable="true">Title</th>
            <th scope="col" data-width="80" data-align="center">Edit</th>
            <th scope="col" data-width="100" data-align="center">Delete</th>
        </tr>
        </thead>
        <tbody>
    <#list tasks as task>
    <tr>
        <td scope="row"
            style="word-break: break-all">
            ${task.name}
        </td>
        <td scope="row" align="center">
            <a href="/businessInfo/task/edit/${task.id}" class="btn btn-outline-primary btn-sm">Edit</a>
        </td>
        <td scope="row" align="center">
            <a href="/businessInfo/task/delete/${task.id}" class="btn btn-outline-danger btn-sm">Delete</a>
        </td>
    </tr>
    </#list>
        </tbody>
    </table>
</div>

<div>
    <div class="form-inline float-left mt-2"><h4>Tools</h4></div>
    <#if isMod>
    <div class="float-right mb-3">
        <a href="/businessInfo/tool/edit/" class="btn btn-primary ml-5" style="width: 180px; text-align: center">Add new tool</a>
    </div>
    </#if>
</div>

<div class="mt-3">
    <table  class="table table-striped table-bordered table-hover"
            data-toggle="table">
        <thead class="thead-light">
        <tr>
            <th scope="col" data-sortable="true">Title</th>
            <th scope="col" data-width="80" data-align="center">Edit</th>
            <th scope="col" data-width="100" data-align="center">Delete</th>
        </tr>
        </thead>
        <tbody>
    <#list tools as tool>
    <tr>
        <td scope="row">
            ${tool.name}
        </td>
        <td scope="row" align="center">
            <a href="/businessInfo/tool/edit/${tool.id}" class="btn btn-outline-primary btn-sm">Edit</a>
        </td>
        <td scope="row" align="center">
            <a href="/businessInfo/tool/delete/${tool.id}" class="btn btn-outline-danger btn-sm">Delete</a>
        </td>
    </tr>
    </#list>
        </tbody>
    </table>
</div>
</@c.page>