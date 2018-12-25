<#import "parts/common.ftl" as common>

<@common.page>

<!-- Modal -->
<div class="modal fade bd-example1-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="false">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Photo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <#include "parts/files.ftl">
                </div>
            </div>
        </div>
    </div>
</div>

<form method="post" action="/newArticles" enctype="multipart/form-data">

    <div class="form-group">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-row">

            <!-- Large modal -->
            <div class="form-group col-md-1">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example1-modal-lg">
                    Photo
                </button>
            </div>

            <div class="form-group col-md-3">
                <input class="form-control" type="text" name="theme" placeholder="Заголовок"
                    value="<#if article??>${article.theme}</#if>">
                <#if themeError??>
                    <div class="invalid-feedback">
                    ${themeError}
                    </div>
                </#if>
            </div>
            <div class="form-group col-md-5">
                <input class="form-control" type="text" name="briefDescriptions" placeholder="Краткое описания">
            </div>
            <div class="form-group col-md-3">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="photo" id="Photo"/>
                    <label class="custom-file-label" for="Photo">Photo</label>
                </div>
            </div>

        </div>
        <br/>
        <textarea class="form-control ${(textError??)?string('is-invalid', '')}"
                    name="text" rows="15" placeholder="Напишите статью">
                <#if article??>${article.text}</#if>
        </textarea>
        <#if textError??>
        <div class="invalid-feedback">
            ${textError}
        </div>
        </#if>
        <br/>

        <!-- Large modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">
            Preview
        </button>

        <!-- Modal -->
        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary" type="submit">Save</button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            ...
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary" type="submit">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</@common.page>