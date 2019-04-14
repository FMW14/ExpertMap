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
        <#--<th></th>-->
    </tr>

    </thead>
    <tbody>
    <#list experts as e>
    <tr>
        <td>${e.name}</td>
        <td>${e.surname}</td>
        <td>${e.patronymic}</td>
        <#--<td><a href="/user/${user.id}">edit</a> </td>-->
    </tr>
    </#list>
    </tbody>


</table>
<#--<button type="button">Save</button>-->
</@c.page>