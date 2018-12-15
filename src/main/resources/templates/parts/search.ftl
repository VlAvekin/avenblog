<!--Search-->
<#macro search search>
<form method="get" action="/blog" class="form-inline my-2 my-lg-0">
    <input class="form-control mr-sm-2" type="text" name="search" value="${search}">
    <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
</form>
</#macro>