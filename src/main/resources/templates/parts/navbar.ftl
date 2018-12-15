<#import "login.ftl" as login>
<#import "search.ftl" as searchs>

<#include "security.ftl">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Aven Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/blog">Blog <span class="sr-only">(current)</span></a>
            </li>

            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/newArticles">New Articles<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user">User List <span class="sr-only">(current)</span></a>
            </li>
            </#if>

            <#if isAdmin> <@searchs.search search?ifExists/> </#if>

        </ul>

        <div class="navbar-text">${name}</div>

        <@login.logout/>
    </div>
</nav>