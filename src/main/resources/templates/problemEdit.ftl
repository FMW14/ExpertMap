<#import "parts/common.ftl" as c>

<@c.page>


<#--<div class="form-check">-->
    <#--<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">-->
    <#--<label class="form-check-label" for="exampleRadios1">-->
        <#--Default radio-->
    <#--</label>-->
<#--</div>-->
<#--<div class="form-check">-->
    <#--<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">-->
    <#--<label class="form-check-label" for="exampleRadios2">-->
        <#--Second default radio-->
    <#--</label>-->
<#--</div>-->



<div class="card mx-auto" style="max-width: 30rem;">
    <h5 class="card-header">Edit problem</h5>
    <div class="card-body">

        <#--<h5 class="card-title">Edit problem</h5>-->
        <div class="form-group">
            <form action="/businessInfo/problem/edit" method="post">
                <#--<label for="problemName" class="mb-1">Title: </label>-->
                <input class="form-control mb-1"
                       type="text"
                       name="problemName"
                       id="problemName"
                       value="${problem.name?if_exists}"
                       placeholder="Enter the title"
                />
                    <#if emptyName??>
                    <div class="invalid-feedback">
                        ${emptyName}
                    </div>
                    </#if>

                <label class="card-text mb-0 mt-1">Select tasks:</label>
                <div>
                <#list probTasks as task>
                <#--<b>${task.name}</b>-->
                    <div>
                        <input id="taskCheckbox${task.id}"
                               type="checkbox"
                               name="${task.id}"
                               <#--style="width: 1.25rem !important; height: 1.25rem !important;"-->
                            ${problem.tasks?if_exists?seq_contains(task)?string("checked", "")}
                        />

                        <label for="taskCheckbox${task.id}"
                               class="form-check-label">
                            ${task.name}
                        </label>
                    </div>
                <#else >
                 No tasks
                </#list>

                </div>
                    <label class="card-text mb-0 mt-1">Select type:</label>
                    <div>
                        <#--<#assign t = prtype>-->
                        <#--${problem.type}-->
                        <div class="form-check">
                            <#--<#if problem.type?if_exists == true>checked</#if>-->
                            <input class="form-check-input"
                                   type="radio" name="problemType"
                                   id="TypeExternal"
                                   value="1"
                                   <#if problem.type??>
                                       ${problem.type?then("checked", "")}
                                   <#else>
                                   ""
                                   </#if>
                                   <#--<#if t>-->
                                       <#--${t?then("checked", "")}-->
                                   <#--</#if>-->
                                <#--${problem.type?if_exists?then("checked", "")} -->
                            >
                            <label class="form-check-label" for="TypeExternal">
                                External problem
                            </label>
                        </div>
                        <div class="form-check">
                            <#--<#if problem.type?if_exists == false>checked</#if>-->
                            <input class="form-check-input"
                                   type="radio"
                                   name="problemType"
                                   id="TypeInternal"
                                   value="0"
                                   <#--<#if t>-->
                                       <#--${t?then("", "checked")}-->
                                   <#--</#if>-->
                                   <#if problem.type??>
                                       ${problem.type?then("", "checked")}
                                   <#else>
                                   ""
                                   </#if>
                                <#--${problem.type?then("checked", "")?if_exists}-->
                            >
                            <label class="form-check-label" for="TypeInternal">
                                Internal problem
                            </label>
                        </div>
                    </div>

                <input type="hidden" value="${problem.id?if_exists}" name="problemId" />
                <input type="hidden" value="${_csrf.token}" name="_csrf" />
                    <div class="form-inline float-right">
                        <button type="submit" class="btn btn-primary mr-3" >Save</button>
                        <a href="/businessInfo" class="btn btn-outline-primary">Cancel</a>
                    </div>
                <#--<button type="submit" class="btn btn-primary">Save</button>-->
            </form>
        </div>





        <#--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>-->
        <#--<a href="#" class="btn btn-primary">Go somewhere</a>-->
    </div>
</div>
</@c.page>