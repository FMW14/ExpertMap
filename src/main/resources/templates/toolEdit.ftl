<#import "parts/common.ftl" as c>

<@c.page>

<div class="card mx-auto" style="max-width: 30rem;">
    <h5 class="card-header">
        <#if tool.id??>
            Edit tool
        <#else >
            Add new tool
        </#if>
    </h5>
    <div class="card-body">
        <form action="/businessInfo/tool/post" method="post">
            <div class="form-group">
                <input class="form-control text-primary ${(nameError??)?string('is-invalid', '')}"
                       type="text"
                       name="name"
                       placeholder="Enter the title"
                       autocomplete="off"
                       value="${tool.name?if_exists}"
                <#--value="<#if message??>${tool.name}</#if>"-->
                />
        <#if nameError??>
            <div class="invalid-feedback">
                ${nameError}
            </div>
        </#if>
            </div>

            <input type="hidden" value="${tool.id?if_exists}" name="Id"/>
            <input type="hidden" value="${_csrf.token}" name="_csrf"/>

            <div class="form-inline float-right mt-3">
                <button type="submit" class="btn btn-primary mr-3">Save</button>
                <a href="/businessInfo" class="btn btn-outline-primary">Cancel</a>
            </div>
        </form>
    </div>
</div>
</@c.page>