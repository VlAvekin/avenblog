<#import "parts/common.ftl" as common>
<#include "parts/security.ftl">

<@common.page>
<link rel="stylesheet" href="/static/css/style.css">
    <div class="form-row">
        <div class="form-group col-md-8">
            <div>
                <h1>${articles.theme}</h1>
                <div class="row">
                    <div class="col">
                        <h4 class="card-text text-left">${articles.authorName}</h4>
                    </div>

                    <#if articles.author.id == currentUserId>
                                <div class="col" style="text-align: center;">
                                    <a href="/newArticles/${articles.author.id}?article=${articles.id}">
                                    <button type="button" class="btn btn-primary">Edit</button>
                                    </a>
                                </div>
                     </#if>

                    <div class="col">
                         <p class="card-text text-right">${articles.creationData}</p>
                    </div>
                 </div>
                <hr>
                <div class="col">
                    <pre id="result">${articles.text}</pre>
                </div>
            </div>
            <br>
            <hr>
            <div>
                <#if user??>
                <form method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <#--<label for="exampleFormControlTextarea1">Сomments</label>-->
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                                  type= "text" name="textComment"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                </#if>
                <br>
                    <#list comments![] as comment>
                        <div style="
                            padding: 5px;
                            margin-right: 0;
                            margin-left: 0;
                            border: 1px solid #E5E6E7;
                            border-radius: 5px;">
                        <div class="toast fade show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                            <div class="row">
                                <div class="col">
                                    <svg class="bd-placeholder-img rounded mr-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect fill="#007aff" width="100%" height="100%"></rect></svg>
                                    <strong class="card-text text-left">${comment.author.username}</strong>
                                </div>

                                <div class="col">
                                     <p class="card-text text-right">${comment.creationData}</p>
                                </div>
                                <#if isAdmin>
                                <div class="col">
                                    <form method="post" action="/articles/${articles.id}/${comment.id}">
                                       <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                                           <button type="submit" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                                               <span aria-hidden="true">&times;</span>
                                           </button>
                                    </form>
                                </div>
                                </#if>
                            </div>
                        </div>
                        <div class="toast-body">
                        ${comment.text}
                        </div>
                        </div>
                        </div>
                        <br>
                    </#list>
                <div>
        </div>
        <div class="form-group col-md-4">

        </div>
    </div>
<script type="text/javascript" src="/static/js/script.js"></script>
</@common.page>