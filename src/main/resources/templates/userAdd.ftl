<#import "parts/common.ftl" as c>

<@c.page>
<div class="card mx-auto" style="max-width: 30rem;">
    <h5 class="card-header">Add new user</h5>
    <div class="card-body">
        <form action="/user/adduser" class="col-12" method="post">
            <div class="form-row mb-3">
                <label class="col-form-label col-md-5">Name</label>
                <input class="form-control col-md-7" type="text" placeholder="Enter user name" name="username" id="userName" />
            </div>
            <div class="form-row mb-3">
                <label class="col-form-label col-md-5">Password</label>
                <input class="form-control col-md-7" type="password" placeholder="Enter password" name="password" id="password" />
            </div>
            <div class="form-row mb-3">
                <label class="col-form-label col-md-5">Confirm password</label>
                <input class="form-control col-md-7" type="password" placeholder="Confirm password" name="password2" id="password" />
            </div>



            <#--<input class="form-control mb-3"-->
                   <#--type="text"-->
                   <#--name="userName"-->
                   <#--placeholder="Enter user name"/>-->

            <label class="card-text mb-0">Select roles:</label>
            <#list roles as role>
                <div>
                    <input type="checkbox"
                           class="mr-1"
                           id="${role}"
                           name="${role}"/>
                    <label class="form-check-label" for="${role}">${role}</label>
                </div>
            </#list>

            <input type="hidden" value="${_csrf.token}" name="_csrf"/>
            <div class="form-inline float-right">
                <button type="submit" class="btn btn-primary mr-3">Save</button>
                <a href="/user" class="btn btn-outline-primary">Cancel</a>
            </div>
        </form>
    </div>
</div>




    <#--<div class="form-group">-->
        <#--<div><h5 name="username">Edit roles <br/>User: ${user.username}</h5></div>-->


        <#--<input type="hidden" value="${user.id}" name="userId"/>-->

    <#--</div>-->
    <#--<button type="submit" class="btn btn-primary">Save</button>-->

</@c.page>
