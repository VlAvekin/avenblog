<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<#import "parts/search.ftl" as searchs>

<@common.page>

    <#list articles as article>
    <div class="card mb-3">
        <a href="/articles/${article.id}">
            <img class="card-img-top" src="/img/${article.photo}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${article.theme}</h5>

                <p class="card-text">${article.briefDescriptions}</p>
                <p class="card-text">${article.authorName}</p>
            </div>
        </a>
    </div>
    <#else>
        No Articles
    </#list>


</@common.page>