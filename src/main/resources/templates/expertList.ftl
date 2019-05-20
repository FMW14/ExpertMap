<#import "parts/common.ftl" as c>

<@c.page>
<link href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>


<#--<script>-->
    <#--$(document).ready(function() {-->
        <#--$("#expertlist")-->
                <#--.tablesorter({-->
                    <#--// headers: { 0: { sorter: false }, 1: { sorter: false }, 6: { sorter: false }},-->
                    <#--sortList: [[0, 0], [1, 0]],-->
                    <#--// widthFixed: true,-->
                    <#--cssAsc: 'up',-->
                    <#--cssDesc: 'down',-->
                    <#--// widgets: ['zebra']-->
                    <#--widgets : [ 'uitheme' , 'stickyHeaders']-->
                <#--})-->
                <#--// .tablesorterPager({container: $("#pager")});-->
    <#--});-->
<#--</script>-->

<div>
    <div class="form-inline float-left mt-2"><h4>Expert list</h4></div>
    <div class="float-right mb-3">
        <a href="/expertList/expert/new/" class="btn btn-primary ml-5" style="width: 180px; text-align: center">Add new expert</a>
    </div>
</div>
<#--<a ">Add new expert</a>-->

<table id="expertlist"
       class="table table-striped table-bordered table-sm table-hover"
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
        <th scope="col" data-width="80" data-align="center">Edit</th>
        <th scope="col" data-width="100" data-align="center">Delete</th>
    </tr>
    </thead>
    <tbody>
    <#list experts as e>
    <tr>
        <td scope="row">${e.name}</td>
        <td scope="row">${e.surname}</td>
        <td scope="row">${e.patronymic}</td>
        <td scope="row">${e.country.titleru?if_exists}</td>
        <td scope="row">${e.city?if_exists}</td>
        <td scope="row">${e.email?if_exists}</td>
        <td scope="row"><a href="/expertList/expert/edit/${e.id}" class="btn btn-outline-primary btn-sm">Edit</a></td>
        <td scope="row"><a href="/expertList/expert/delete/${e.id}" class="btn btn-outline-danger btn-sm">Delete</a></td>
        <#--<td><a href="/user/${user.id}">edit</a> </td>-->
    </tr>
    </#list>
    </tbody>


</table>


<#--<button type="button">Save</button>-->
</@c.page>