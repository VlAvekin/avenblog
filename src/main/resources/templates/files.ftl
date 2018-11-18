<#import "parts/common.ftl" as common>

<@common.page>

    <div>
        <span><a href="/blog">Backwards</a></span>
    </div>

    <form method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="file" name="file"/>
        <button type="submit">Добавить</button>
    </form>

    <#list files as file>
        <div>
            <#if file.filename??>
                <a href="/img/${file.filename}">
                    <b>${file.id}</b>
                    <span>${file.filename}</span>
                    <img src="/img/${file.filename}">
                </a>
            </#if>
        </div>
    <#else>
        No Files
    </#list>
</@common.page>