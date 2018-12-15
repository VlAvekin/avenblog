<#macro login path isRegisterForm>
    <form action="${path}" method="post">

        <div class="form-group row">

            <label class="col-sm-2 col-form-label"> User Name : </label>
            <div class="col-sm-10">
                <input type="text" name="username"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password : </label>
            <div class="col-sm-10">
                <input type="password" name="password"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <#if !isRegisterForm><a href="/registration">Add new user</a></#if>

        <div class="form-group row">
            <button type="submit" class="btn btn-primary">
                <#if isRegisterForm>Create <#else>Sign In </#if>
            </button>
        </div>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">
            Sign Out
        </button>
    </form>
</#macro>