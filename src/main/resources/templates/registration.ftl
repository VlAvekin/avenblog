<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
<div class="container mt-5">
    Add new user

    ${articles?ifExists}

    <@login.login "/registration" true/>
</div>
</@common.page>