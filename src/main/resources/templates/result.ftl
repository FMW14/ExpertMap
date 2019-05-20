<#import "parts/common.ftl" as c>
<@c.page>
<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>

<table class="table table-striped table-bordered table-hover"
       data-toggle="table">
    <thead class="thead-light">
    <tr>
        <th scope="col" data-sortable="true">Tool title</th>
        <th scope="col" data-sortable="true">Rate</th>
    </tr>
    </thead>
    <tbody>
    <#list tools as t>
    <tr>
        <td>
            ${t.toolname}
        </td>
        <td>
            ${t.rate}
        </td>
    </tr>
    <#else >
    </#list>
    </tbody>

</table>

<table id="expertlist"
       class="table table-striped table-bordered table-sm table-hover mt-5"
       data-toggle="table"
       data-pagination="true"
       data-sort-name="name">
    <thead class="thead-light">
    <tr>
        <th scope="col" data-sortable="true" data-field="name">Name</th>
        <th scope="col" data-sortable="true">Surname</th>
        <th scope="col" data-sortable="true">Patronymic</th>
        <th scope="col" data-sortable="true">Country</th>
        <th scope="col" data-sortable="true">City</th>
        <th scope="col" data-sortable="true">Email</th>
        <#list tools as t>
            <td scope="row">${t.toolname?if_exists}</td>
        </#list>
    <#list toolslist as tl>
        <th scope="col" data-sortable="true">${tl.name}</th>
    </#list>
    </tr>
    </thead>
    <tbody>
    <#list experts as e>
    <tr>
        <td scope="row">${e.name}</td>
        <td scope="row">${e.surname}</td>
        <td scope="row">${e.patronymic}</td>
        <td scope="row">${e.country?if_exists}</td>
        <td scope="row">${e.city?if_exists}</td>
        <td scope="row">${e.email?if_exists}</td>
        <#list e.expertToolDtos as et>
            <td scope="row">${et.rating?if_exists}</td>
        </#list>
    </tr>
    </#list>
    </tbody>


</table>

</@c.page>