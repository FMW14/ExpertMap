<#import "parts/common.ftl" as c>

<@c.page>
Edit expert

<form action="/expertList/expert/edit" method="post">
    <div class="form-group">
        <label for="expertName">Name</label>
        <input class="form-control" type="text" placeholder="Name" name="expertName" id="expertName" value="${expert.name?if_exists}" />
    </div>
    <div class="form-group">
        <label for="expertName">Surname</label>
        <input class="form-control" type="text" placeholder="Surname" name="expertSurname" id="expertSurname" value="${expert.surname?if_exists}" />
    </div>
    <div class="form-group">
        <label for="expertName">Patronymic</label>
        <input class="form-control" type="text" placeholder="Patronymic" name="expertPatronymic" id="expertPatronymic"  value="${expert.patronymic?if_exists}" />
    </div>



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

<#--<div>-->
    <#--<select id="expertCountry" name="expertCountry" >-->
                <#--<#list problems as problem>-->
                    <#--<option value="${problem.id}">${problem.name}</option>-->
                <#--</#list>-->
    <#--</select>-->
<#--</div>-->

    <div>
        <label for="expertCountry">Country</label>
        <#--class="form-control"-->
        <input class="custom-select my-1 mr-sm-2"
               autocomplete="on"
               type="text"
               placeholder="Country"
               name="expertCountry"
               id="expertCountry"
               list="countryList"
               value="${expert.country?if_exists}" />
        <#--<input type="text" list="cars" />-->
        <datalist id="countryList">
            <#list countries as cnt>
                <option id=${cnt.id}>${cnt.title_ru}</option>
            <#else >
                No country list
            </#list>
        </datalist>
    </div>

</@c.page>