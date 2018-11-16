<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>

    <div>
        <@login.logout />
    </div>

    <div>
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="theme" placeholder="Заголовок">
            <input type="text" name="briefDescriptions" placeholder="Краткое описания">
            <input type="text" name="text" placeholder="Введите сообшения">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <!--Search-->
    <form method="get" action="/main">
        <input type="text" name="search">
        <button type="submit">Найти</button>
    </form>


    <#list articles as article>
    <div>
        <b>${article.id}</b>
        <span>${article.theme}</span>
        <span>${article.briefDescriptions}</span>
        <span>${article.text}</span>
        <strong>${article.authorName}</strong>
        <br>
    </div>
    <#else>
        No Articles
    </#list>

</@common.page>

    <!--<script type="text/javascript">-->
        <!--window.onload = function(){-->
            <!--document.getElementById("exampleFormControlTextarea2").onkeyup = function(){-->
                <!--var getText = this.value;-->
                <!--var getRegs = getText.match(/^.*(\r\n|\n|$)/gim);-->
                <!--var setText = false;-->
                <!--for(var i = 0; i < getRegs.length; i++){-->
                    <!--getText = getRegs[i].replace(/\r|\n/g, "");-->
                    <!--setText += getText.length ? Math.ceil(getText.length / 50) : 1;-->
                <!--}-->
                <!--if (setText < 15) {-->
                    <!--this.rows = 15;-->
                <!--} else {-->
                    <!--this.rows = setText;-->
                <!--}-->
            <!--};-->
        <!--};-->
    <!--</script>-->