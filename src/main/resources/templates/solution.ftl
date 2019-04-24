<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<a href="/">Main page</a>
<br/>

<p>
<div>Выбор проблемы:</div>
    <div>
        <select id="problemList" name="problemList" >
                <#list problems as problem>
                    <option value="${problem.id}">${problem.name}</option>
                </#list>
        </select>
    </div>
</p>

<div>Выбор задач:</div>
    <div>
    <#--<#list tasks as task>-->
        <#--<div>-->
            <#--&lt;#&ndash;<label><input type="checkbox" name="${task.id}" ${task.name?seq_contains(task)?string("checked", "")} />${task}</label>&ndash;&gt;-->
        <#--</div>-->
        <#--<select id="taskList" name="taskList" >-->
                <#--<#list tasks as task>-->
                    <#--<option value="${task.id}">${task.name}</option>-->
                <#--</#list>-->
        <#--</select>-->
    </div>

<table id="tasks" class="tasks">
    <tr>
        <th>Name</th>
    </tr>
    <#list tasks as task>
        <tr>
            <td class="name">${task.name?capitalize}</td>
            <td><div location="button-${task.id}" /></td>
        </tr>
    </#list>
</table>


<div id="app">
    {{ msg }}
</div>
<script>
var app = new Vue({
el: '#app',
data: {
msg: 'Привет, Vue!'
}
})
</script>
<#--<script src="/static/js/main.js"></script>-->

</@c.page>