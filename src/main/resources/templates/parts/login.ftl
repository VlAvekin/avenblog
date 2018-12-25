<#macro login path isRegisterForm>
    <form action="${path}" method="post">

        <div class="form-group row">

            <label class="col-sm-2 col-form-label"> User Name : </label>
            <div class="col-sm-6">
                <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="User Name"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                    ${usernameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password : </label>
            <div class="col-sm-6">
                <input type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                    ${passwordError}
                    </div>
                </#if>
            </div>
        </div>

        <#if isRegisterForm>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password : </label>
            <div class="col-sm-6">
                <input type="password" name="password2"
                    class="form-control ${(password2Error??)?string('is-invalid', '')}"
                    placeholder="Password"/>
                <#if password2Error??>
                    <div class="invalid-feedback">
                    ${password2Error}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email : </label>
            <div class="col-sm-6">
                <input type="email" name="email" value="<#if user??>${user.email}</#if>"
                       class="form-control ${(emailError??)?string('is-invalid', '')}"
                       placeholder="some@some.com"/>
                    <#if emailError??>
                        <div class="invalid-feedback">
                        ${emailError}
                        </div>
                    </#if>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="g-recaptcha" data-sitekey="6Lf1t4QUAAAAABFO-yhOXu0pG2Q85r5SkN8qlUyt"></div>
            <#if captchaError??>
                <div class="alert alert-danger">
                ${captchaError}
                </div>
            </#if>
        </div>
        </#if>

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