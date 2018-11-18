<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>

    <div>
        <@login.logout />
        <span><a href="/user">User List</a></span>
    </div>

    <div>
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="theme" placeholder="Заголовок">
            <input type="text" name="briefDescriptions" placeholder="Краткое описания">
            <textarea name="text" placeholder="Введите сообшения"></textarea>
            <button type="submit">Добавить</button>
        </form>
    </div>
        <span><a href="/files">Files add</a></span>
    <div>

    </div>

    <!--Search-->
    <form method="get" action="/blog">
        <input type="text" name="search" value="${search?ifExists}">
        <button type="submit">Найти</button>
    </form>


    <#list articles as article>
    <div>
        <a href="/articles/${article.id}">
            <b>${article.id}</b>
            <span>${article.theme}</span>
            <span>${article.briefDescriptions}</span>
            ${article.text}
            <strong>${article.authorName}</strong>
            <br>
        </a>
    </div>
    <#else>
        No Articles
    </#list>

</@common.page>