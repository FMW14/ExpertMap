<#import "parts/common.ftl" as c>

<@c.page>
<a href="/">Main page</a>
<br/>
Expert list

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Patronymic</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    </thead>
    <tbody>
    <#list experts as e>
    <tr>
        <td>${e.name}</td>
        <td>${e.surname}</td>
        <td>${e.patronymic}</td>
        <td><a href="/expertList/expert/edit/${e.id}">Edit info</a></td>
        <td><a href="/expertList/expert/delete/${e.id}">Delete</a></td>
        <#--<td><a href="/user/${user.id}">edit</a> </td>-->
    </tr>
    </#list>
    </tbody>


</table>

<a href="/expertList/expert/new/">Add new expert</a>
<#--<button type="button">Save</button>-->
</@c.page>