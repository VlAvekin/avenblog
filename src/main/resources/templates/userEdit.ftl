<#import "parts/common.ftl" as common>

<@common.page>
<div class="container mt-5">
    User editor

    <form action="/user" method="post">
        <input type="text" value="${user.username}" name="username"/>
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}/>
                    ${role}
                </label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Save</button>
    </form>
</div>
</@common.page>