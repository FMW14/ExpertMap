<#import "parts/common.ftl" as c>

<@c.page>
Edit expert

<form action="/expertList/expert/edit" method="post">
    <input type="text" placeholder="Name" name="expertName" value="${expert.name?if_exists}" />
    <input type="text" placeholder="Surname" name="expertSurname" value="${expert.surname?if_exists}" />
    <input type="text" placeholder="Patronymic" name="expertPatronymic" value="${expert.patronymic?if_exists}" />
    <#list rate as rt>
    <div>
        <b>${rt.toolname}</b>
        <select id=${rt.toolname} name=${rt.toolname} >
            <#--<#list rate as r>-->
                <#--<#if expert.expertTools.g == actualyear>selected</#if>-->
                <#--<option value="<#if expert??>${}</#if>">${r}</option>-->
                <#--<#assign options = { "1": "1", "2": "2", "3": "3", "4": "4", "5": "5"} />-->
                <#--<option value=${r}>${r}</option>-->
                <option value="0" <#if rt.rate == 0>selected</#if>>0</option>
                <option value="1" <#if rt.rate == 1>selected</#if>>1</option>
                <option value="2" <#if rt.rate == 2>selected</#if>>2</option>
                <option value="3" <#if rt.rate == 3>selected</#if>>3</option>
                <option value="4" <#if rt.rate == 4>selected</#if>>4</option>
                <option value="5" <#if rt.rate == 5>selected</#if>>5</option>
                <#--<option value="${rt.rate}" selected="selected">${rt.rate}</option>-->

            <#--</#list>-->
        </select>
    </div>


    <#--<div>-->
        <#--<label><input type="checkbox" name="${tool.id}" ${task.tools?if_exists?seq_contains(tool)?string("checked", "")} />${tool.name}</label>-->
    <#--</div>-->
    <#else >
        No tools
    </#list>
    <input type="hidden" value="${expert.id?if_exists}" name="expertId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />
    <button type="submit">Save</button>
</form>
</@c.page>