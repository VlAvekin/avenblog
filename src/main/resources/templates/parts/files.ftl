<div class="container-fluid">
    <form method="post" action="/parts/file" enctype="multipart/form-data">
        <div class="form-group">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-row">
                <div class="form-group col-md-9">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="file" id="customFile"/>
                        <label class="custom-file-label" for="customFile">Photo</label>
                    </div>
                </div>
                <div class="form-group col-md-3">
                    <button class="btn btn-primary" type="submit">Add</button>
                </div>
            </div>
        </div>
    </form>

    <!--Search-->
    <#--<form method="get" action="/parts/file">-->
        <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <#--<div class="form-group">-->
            <#--<div class="form-row">-->
                <#--<div class="form-group col-md-9">-->
                    <#--<div class="form-group col-md-9">-->
                        <#--<input class="form-control" type="text" name="search" value="${search?ifExists}">-->
                    <#--</div>-->
                    <#--<div class="form-group col-md-3">-->
                        <#--<button class="btn btn-primary" type="submit">Search</button>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</form>-->

    <div class="card-columns">
    <#list files as file>

            <#if file.filename??>
                <div class="card my-3">
                    <img class="card-img-top" src="/img/${file.filename}" />
                    <#--<div class="card-body">-->
                        <#--<h5 class="card-title">${file.filename}</h5>-->
                    <#--</div>-->
                </div>
            </#if>

    <#else>
        No Files
    </#list>
    </div>
</div>
