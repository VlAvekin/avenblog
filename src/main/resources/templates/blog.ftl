<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<#import "parts/search.ftl" as searchs>

<@common.page>

    <div class="form-row">
        <div class="form-group col-md-8">
            <#list articles as article>
            <div class="card mb-3 text-center">
                <a href="/articles/${article.id}">
                    <img class="card-img-top" src="/img/${article.photo}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${article.theme}</h5>
                        <p class="card-text">${article.briefDescriptions}</p>
                    </div>
                    <div class="card-footer text-muted">
                        <div class="form-row">
                            <div class="col mb-6">
                                <p class="card-text text-left">${article.authorName}</p>
                            </div>

                            <div class="col mb-6">
                                <p class="card-text text-right">Last updated 3 mins ago</p>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <#else>
                No Articles
            </#list>
        </div>

        <div class="form-group col-md-4">

        </div>

    <div

    <#include "parts/footer.ftl">
</@common.page>