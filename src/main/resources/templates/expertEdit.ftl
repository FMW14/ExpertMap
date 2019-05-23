<#import "parts/common.ftl" as c>

<@c.page>
<div class="card mx-auto" style="max-width: 40rem;">
    <h5 class="card-header">Edit expert</h5>
    <div class="card-body">
<form action="/expertList/expert/edit" method="post" class="col-12">
    <div class="form-row mb-3">
        <label class="col-form-label col-md-2">Name</label>
        <input class="form-control col-md-10" type="text" placeholder="Name" name="expertName" id="expertName" value="${expert.name?if_exists}" />
    </div>
    <div class="form-row mb-3">
        <label for="expertName" class="col-form-label col-md-2">Surname</label>
        <input class="form-control col-md-10" type="text" placeholder="Surname" name="expertSurname" id="expertSurname" value="${expert.surname?if_exists}" />
    </div>
    <div class="form-row mb-3">
        <label for="expertName" class="col-form-label col-md-2">Patronymic</label>
        <input class="form-control col-md-10" type="text" placeholder="Patronymic" name="expertPatronymic" id="expertPatronymic"  value="${expert.patronymic?if_exists}" />
    </div>
    <div class="form-row mb-3">
        <label for="expertEmail" class="col-form-label col-md-2">Email</label>
        <input class="form-control col-md-10" type="email" placeholder="Email" name="expertEmail" id="expertEmail"  value="${expert.email?if_exists}" />
    </div>
    <div class="form-row mb-3">
        <label for="expertPhone" class="col-form-label col-md-2">Phone</label>
        <input class="form-control col-md-10" type="text" placeholder="Phone" name="expertPhone" id="expertPhone"  value="${expert.phone?if_exists}" />
    </div>

    <div class="form-row mb-3">
        <label for="expertCountry" class="col-form-label col-md-2">Country</label>
        <select id="expertCountry" name="expertCountry" class="form-control col-md-10 ">
            <option value="" selected disabled>Select country</option>
             <#list countries as cnt>
                 <option value=${cnt.country_id}
                     <#if expert.country??>
                        <#if expert.country.country_id == cnt.country_id>selected</#if>
                     </#if>
                 >
                     ${cnt.titleru}
                 </option>
             <#else >
                No country list
             </#list>
        </select>
    </div>
    <div class="form-row mb-3">
        <label for="expertCity" class="col-form-label col-md-2">City</label>
        <input id="expertCity"
               name="expertCity"
               placeholder="Enter city"
               class="form-control col-md-10"
               value="${expert.city?if_exists}">
        </input>
    </div>
    <#--<div class="invalid-feedback">-->
        <#--Please provide a valid city.-->
    <#--</div>-->

    <#list rate as rt>
    <div class="form-row mb-2">
        <select class="form-control form-control-sm mr-3"
                id=${rt.toolname}
                name=${rt.toolname}
                style="width: 3rem">
                <option value="0" <#if rt.rate == 0>selected</#if>>0</option>
                <option value="1" <#if rt.rate == 1>selected</#if>>1</option>
                <option value="2" <#if rt.rate == 2>selected</#if>>2</option>
                <option value="3" <#if rt.rate == 3>selected</#if>>3</option>
                <option value="4" <#if rt.rate == 4>selected</#if>>4</option>
                <option value="5" <#if rt.rate == 5>selected</#if>>5</option>
        </select>
        <label class="col-form-label" >${rt.toolname} </label>
    </div>
    <#else >
        No tools
    </#list>

    <div>
        <input id="onlineAccess"
               type="checkbox"
               name="onlineAccess"
        <#--style="width: 1.25rem !important; height: 1.25rem !important;"-->
               <#--problem.tasks?if_exists?seq_contains(task)?string("checked", "")-->
                <#if expert.online??>
                    ${expert.online?then("checked", "")}
                </#if>
        />

        <label for="onlineAccess"
               class="form-check-label">
            Online access
        </label>
    </div>

    <div>
        <input id="offlineAccess"
               type="checkbox"
               name="offlineAccess"
               <#if expert.offline??>
                    ${expert.offline?then("checked", "")}
               </#if>
        />

        <label for="offlineAccess"
               class="form-check-label">
            Offline access
        </label>
    </div>


    <input type="hidden" value="${expert.id?if_exists}" name="expertId" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />

    <div class="form-inline float-right">
        <button type="submit" class="btn btn-primary mr-3" >Save</button>
        <a href="/expertList" class="btn btn-outline-primary">Cancel</a>
    </div>
    </form>
    </div>
</div>
</@c.page>