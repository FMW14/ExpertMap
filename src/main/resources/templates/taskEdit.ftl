<#import "parts/common.ftl" as c>

<@c.page>
<div class="card mx-auto" style="max-width: 30rem;">
    <h5 class="card-header">
        <#if task.id??>
            Edit task
        <#else >
            Add new task
        </#if>
    </h5>
    <div class="card-body">

        <form action="/businessInfo/task/post" method="post">
            <div class="form-group">
                <input class="form-control mb-1 ${(nameError??)?string('is-invalid', '')}"
                       type="text"
                       name="name"
                       placeholder="Enter the title"
                       value="${task.name?if_exists}"/>
                <#if nameError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>

            <label class="card-text mb-0 mt-1">Select tools:</label>
    <#list taskTools as tool>
    <#--<b>${tool.name}</b>-->
    <div style="word-break: break-all">
        <span class="align-middle">
        <input type="checkbox" id="${tool.id}"
               name="${tool.id}" ${task.tools?if_exists?seq_contains(tool)?string("checked", "")}
               style="width: 1.00rem !important; height: 1.00rem !important;"/>
            </span>
        <label class="form-check-label" for="${tool.id}">${tool.name}</label>
    </div>
    <#else >
        No tools
    </#list>
            <input type="hidden" value="${task.id?if_exists}" name="Id"/>
            <input type="hidden" value="${_csrf.token}" name="_csrf"/>
            <div class="form-inline float-right">
                <button type="submit" class="btn btn-primary mr-3">Save</button>
                <a href="/businessInfo" class="btn btn-outline-primary">Cancel</a>
            </div>
        </form>
    </div>
</div>
</@c.page>