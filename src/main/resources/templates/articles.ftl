<#import "parts/common.ftl" as common>

<@common.page>
    <div class="form-row">
        <div class="form-group col-md-8">
            <h1>${articles.theme}</h1>
            <h4>${articles.authorName}</h4>
            <hr>
            ${articles.text}
        </div>
        <div class="form-group col-md-4">

        </div>
    </div>
</@common.page>