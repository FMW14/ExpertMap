<#import "parts/common.ftl" as c>

<@c.page>
<div class="card mx-auto" style="max-width: 40rem;">
    <h5 class="card-header">Edit expert</h5>
    <div class="card-body">
<form action="/expertList/expert/edit" method="post" class="col-12">
    <div class="form-row mb-3">
        <label class="col-form-label col-md-2">Name</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <input class="form-control text-primary ${(nameError??)?string('is-invalid', '')}"
               type="text"
               placeholder="Name"
               name="Name"
               id="Name"
               value="${expert.name?if_exists}" />
        <#if nameError??>
            <div class="invalid-feedback">
                ${nameError}
            </div>
        </#if>
        </div>
    </div>
    <div class="form-row mb-3">
        <label for="expertName" class="col-form-label col-md-2">Surname</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <input class="form-control text-primary ${(surnameError??)?string('is-invalid', '')}" type="text" placeholder="Surname" name="Surname" id="Surname" value="${expert.surname?if_exists}" />
            <#if surnameError??>
            <div class="invalid-feedback">
                ${surnameError}
            </div>
            </#if>
        </div>
    </div>
    <div class="form-row mb-3">
        <label for="expertName" class="col-form-label col-md-2">Patronymic</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <input class="form-control text-primary" type="text" placeholder="Patronymic" name="Patronymic" id="Patronymic"  value="${expert.patronymic?if_exists}" />
        </div>
    </div>
    <div class="form-row mb-3">
        <label for="expertEmail" class="col-form-label col-md-2">Email</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <input class="form-control text-primary" type="email" placeholder="Email" name="Email" id="Email"  value="${expert.email?if_exists}" />
        </div>
    </div>
    <div class="form-row mb-3">
        <label for="expertPhone" class="col-form-label col-md-2">Phone</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <input class="form-control text-primary" type="text" placeholder="Phone" name="Phone" id="Phone"  value="${expert.phone?if_exists}" />
        </div>
    </div>

    <div class="form-row mb-3">
        <label for="Country" class="col-form-label col-md-2">Country</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <select id="Country" name="Country" class="form-control text-primary ${(countryError??)?string('is-invalid', '')}">
            <option value=""  selected disabled>Select country</option>
             <#list countries as cnt>
                 <option class="text-dark" value=${cnt.country_id}
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
            <#if countryError??>
            <div class="invalid-feedback">
                ${countryError}
            </div>
            </#if>
        </div>
    </div>
    <div class="form-row mb-3">
        <label for="City" class="col-form-label col-md-2">City</label>
        <div class="col-md-10" style="padding-right:0;padding-left:0;">
        <input class="form-control text-primary"
               id="City"
               name="City"
               placeholder="Enter city"
               value="${expert.city?if_exists}">
        </input>
        </div>
    </div>
    <#--<div class="invalid-feedback">-->
        <#--Please provide a valid city.-->
    <#--</div>-->

    <#list rate as rt>
    <div class="form-row mb-2"
         style="word-break: break-word">
        <span class="align-middle">
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
        </span>
        <label for=name=${rt.toolname} class="col-form-label" >${rt.toolname} </label>
    </div>
    <#else >
        No tools
    </#list>

    <div>
        <span class="align-middle">
        <input id="online"
               type="checkbox"
               name="online"
               style="width: 1.00rem !important; height: 1.00rem !important;"
        <#--style="width: 1.25rem !important; height: 1.25rem !important;"-->
               <#--problem.tasks?if_exists?seq_contains(task)?string("checked", "")-->
                <#if expert.online??>
                    ${expert.online?then("checked", "")}
                </#if>
        />
        </span>

        <label for="online"
               class="form-check-label">
            Online access
        </label>
    </div>
    <div>
        <span class="align-middle">
        <input id="offline"
               type="checkbox"
               name="offline"
               style="width: 1.00rem !important; height: 1.00rem !important;"
               <#if expert.offline??>
                   ${expert.offline?then("checked", "")}
               </#if>
        />
        </span>

        <label for="offlineAccess"
               class="form-check-label">
            Offline access
        </label>
    </div>

    <label class="card-text mb-0 mt-1">Select languages:</label>
    <#list langs as lang>
    <div style="word-break: break-all">
        <span class="align-middle">
        <input type="checkbox"
               id="${lang.id}"
               name="${lang.id}" ${expert.lang?if_exists?seq_contains(lang)?string("checked", "")}
               style="width: 1.00rem !important; height: 1.00rem !important;"/>
            </span>
        <label class="form-check-label" for="${lang.id}">${lang.titleru}</label>
    </div>
    <#else >
        No langs
    </#list>




    <input type="hidden" value="${expert.id?if_exists}" name="Id" />
    <input type="hidden" value="${_csrf.token}" name="_csrf" />

    <div class="form-inline float-right">
        <button type="submit" class="btn btn-primary mr-3" >Save</button>
        <a href="/expertList" class="btn btn-outline-primary">Cancel</a>
    </div>
    </form>
    </div>
</div>
</@c.page>