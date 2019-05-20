<#import "parts/common.ftl" as c>

<@c.page>
<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>

<div>
    <div class="form-inline float-left mt-2"><h4>Problems</h4></div>

    <div class="float-right mb-3">
        <a href="/businessInfo/problem/new/" class="btn btn-primary ml-5 " style="width: 180px; text-align: center">Add new problem</a>
    </div>
</div>
<#--style="width: 100px; text-align: center"-->

<#--<div class="float-right form-inline"><a href="/businessInfo/problem/new/" class="btn btn-primary ml-5 ">Add new problem</a></div>-->
<div class="mt-3 mb-3">
    <table class="table table-striped table-bordered table-hover"
            data-toggle="table">
        <thead class="thead-light">
        <tr>
            <th scope="col" data-sortable="true">Title</th>
            <#--<th scope="col" data-width="50" data-sortable="true">Type</th>-->
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
        <#--<td scope="row">-->
            <#--${problem.type.toString()?if_exists}-->
        <#--</td>-->
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
    <div class="float-right mb-3">
        <a href="/businessInfo/task/new/" class="btn btn-primary ml-5" style="width: 180px; text-align: center">Add new task</a>
    </div>
</div>

<div class="mt-3 mb-3">
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
    <#list tasks as task>
    <tr>
        <td scope="row">
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

<#--<h5>Список задач</h5>-->
    <#--<#list tasks as task>-->
<#--<div>-->
    <#--<b>${task.name}</b>-->
    <#--<a href="/businessInfo/task/edit/${task.id}">edit</a>-->
    <#--<a href="/businessInfo/task/delete/${task.id}">delete</a>-->
<#--</div>-->
    <#--<#else >-->
<#--No tasks-->
    <#--</#list>-->
<#--<a href="/businessInfo/task/new/">Add new task</a>-->

<div>
    <div class="form-inline float-left mt-2"><h4>Tools</h4></div>
    <div class="float-right mb-3">
        <a href="/businessInfo/tool/new/" class="btn btn-primary ml-5" style="width: 180px; text-align: center">Add new tool</a>
    </div>
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




<#--<div class="form-inline">-->
    <#--<h5>Tools</h5>-->
    <#--<a href="/businessInfo/tool/new/" class="btn btn-primary ml-5">Add new tool</a>-->
<#--</div>-->
<#--&lt;#&ndash;<h5>Список инструментов</h5>&ndash;&gt;-->
<#--&lt;#&ndash;<div>Список инструментов</div>&ndash;&gt;-->
    <#--<#list tools as tool>-->
<#--<div>-->
    <#--<b>${tool.name}</b>-->
    <#--<a href="/businessInfo/tool/edit/${tool.id}">edit</a>-->
    <#--<a href="/businessInfo/tool/delete/${tool.id}">delete</a>-->
<#--</div>-->
    <#--<#else >-->
<#--No tools-->
    <#--</#list>-->
<#--&lt;#&ndash;<a href="/businessInfo/tool/new/">Add new tool</a>&ndash;&gt;-->
<#--</p>-->

    <#--${message?if_exists}-->

</@c.page>