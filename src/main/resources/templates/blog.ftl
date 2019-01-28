<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<#include "parts/security.ftl">
<#import "parts/pager.ftl" as p>

<@common.page>
<div class="container mt-5">
    <div class="form-row">
        <div class="form-group col-md-8" id="article-list">
            <@p.pagerCol url page/>
            <@p.pager url page/>
            <#list page.content as article>
            <div class="card mb-3 text-center" >
                <a href="/articles/${article.id}">
                    <img class="card-img-top" src="/img/${article.photo}" alt="Card image cap"/>
                    <div class="card-body">
                        <h5 class="card-title">${article.theme}</h5>
                        <p class="card-text">${article.briefDescriptions}</p>
                    </div>
                    <div class="card-footer text-muted">
                        <div class="row">
                            <div class="col">
                                <p class="card-text text-left">${article.authorName}</p>
                            </div>

                            <#if article.author.id == currentUserId>
                                <div class="col" style="text-align: right;">
                                    <a href="/newArticles/${article.author.id}?article=${article.id}">
                                    <button type="button" class="btn btn-primary">Edit</button>
                                    </a>
                                </div>
                            </#if>

                            <div class="col" >
                                <p class="card-text text-right">${article.creationData}</p>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <#else>
                No Articles
            </#list>
            <@p.pager url page/>
        </div>

        <div class="form-group col-md-4">

        </div>
    </div>
</div>
<#--<@p.pager url page/>-->
</@common.page>