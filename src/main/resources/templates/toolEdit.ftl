<#import "parts/common.ftl" as c>

<@c.page>

<div class="card mx-auto" style="max-width: 30rem;">
    <h5 class="card-header">Edit tool</h5>
    <div class="card-body">
    <form action="/businessInfo/tool/edit" method="post">
    <input class="form-control mb-3"
           type="text"
           name="toolName"
           placeholder="Enter the title"
           value="${tool.name?if_exists}" />

    <input type="hidden" value="${tool.id?if_exists}" name="toolId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />

        <div class="form-inline float-right">
            <button type="submit" class="btn btn-primary mr-3" >Save</button>
            <a href="/businessInfo" class="btn btn-outline-primary">Cancel</a>
        </div>
    </form>
    </div>
</div>
</@c.page>