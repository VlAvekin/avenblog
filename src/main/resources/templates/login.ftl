<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
<div class="container mt-5">
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
        ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
    <#if message??>
        <div class="alert alert-${messageType}" role="alert">
        ${message}
        </div>
    </#if>
<@login.login "/login" false/>
</div>
</@common.page>