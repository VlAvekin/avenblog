<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
${articles?ifExists}
<@login.login "/login" false/>

</@common.page>