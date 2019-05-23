<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="card mx-auto" style="max-width: 30rem;">
    <h5 class="card-header">Edit user</h5>
    <div class="card-body">
        <form action="/user/save" class="col-12" method="post">
            <div class="form-row mb-3">
                <label class="col-form-label col-md-5">Name</label>
                <input class="form-control col-md-7" type="text" placeholder="Enter user name" name="username" id="userName" value="${user.username}" readonly />
            </div>
            <div class="form-row mb-3">
                <label class="col-form-label col-md-5">Password</label>
                <input class="form-control col-md-7" type="password" placeholder="Enter password" name="password" id="password" />
            </div>
            <div class="form-row mb-3">
                <label class="col-form-label col-md-5">Confirm password</label>
                <input class="form-control col-md-7" type="password" placeholder="Enter password" name="password2" id="password2" />
            </div>

            <label class="card-text mb-0">Select roles:</label>
            <#list roles as role>
            <#if role!="ADMIN">
                <div>
                    <span class="align-middle">
                    <input type="checkbox"
                           class="mr-1"
                           id="${role}"
                           name="${role}"
                           style="width: 1.00rem !important; height: 1.00rem !important;"
                           ${user.roles?seq_contains(role)?string("checked", "")}
                    />
                    </span>
                    <label class="form-check-label" for="${role}">${role}</label>
                </div>
            <#else >
                <#if isAdmin>
                <div>
                    <span class="align-middle">
                    <input type="checkbox"
                           class="mr-1"
                           id="${role}"
                           name="${role}"
                           style="width: 1.00rem !important; height: 1.00rem !important;"
                           ${user.roles?seq_contains(role)?string("checked", "")}
                    />
                    </span>
                    <label class="form-check-label" for="${role}">${role}</label>
                </div>
                </#if>
            </#if>
            </#list>

            <input type="hidden" value="${_csrf.token}" name="_csrf"/>
            <input type="hidden" value="${user.id}" name="Id" />
            <div class="form-inline float-right">
                <button type="submit" class="btn btn-primary mr-3">Save</button>
                <a href="/user" class="btn btn-outline-primary">Cancel</a>
            </div>
        </form>
    </div>
</div>


<#--<form action="/user" method="post">-->
    <#--<div class="form-group">-->
    <#--<div><h5 name="username">Edit roles <br/>User: ${user.username}</h5></div>-->

    <#--<#list roles as role>-->
    <#--<div class="ml-4">-->
        <#--<label><input type="checkbox" class="form-check-input" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} />${role}</label>-->
    <#--</div>-->
    <#--</#list>-->
    <#--<input type="hidden" value="${user.id}" name="userId" />-->
    <#--<input type="hidden" value="${_csrf.token}" name="_csrf" />-->
    <#--</div>-->
    <#--<button type="submit" class="btn btn-primary">Save</button>-->
<#--</form>-->
</@c.page>
