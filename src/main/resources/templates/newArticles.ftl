<#import "parts/common.ftl" as common>
<#import "parts/search.ftl" as searchs>

<@common.page>
    <style>
        .articles{
            padding: 0;
            margin: 1% 10px 0 10px;
        }
        #editor-result{
            font-size: 16px;
            white-space: pre-wrap;
            width: 100%;
            height: 100%;
        }
        textarea{

        }
    </style>
<div class="articles">
    <div class="form-row">
        <div class="form-group col-md-5">
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

            <form method="post"  enctype="multipart/form-data">

            <div class="form-group">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#--<input type="hidden" name="id" value="<#if article??>{article.id}</#if>"/>-->
            <div class="form-row">

                <!-- Large modal -->
                <div class="form-group col-md-2">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example1-modal-lg">
                        Photo
                    </button>
                </div>

                <div class="form-group col-md-6">
                    <input class="form-control" type="text" name="theme" placeholder="Заголовок"
                    value="<#if article??>${article.theme}</#if>" />
                    <#if themeError??>
                        <div class="invalid-feedback">
                        ${themeError}
                        </div>
                    </#if>
                </div>
                <div class="form-group col-md-4">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="photo" id="Photo"/>
                        <label class="custom-file-label" for="Photo">Photo</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <input class="form-control" type="text" name="briefDescriptions" placeholder="Краткое описания"
                value="<#if article??>${article.briefDescriptions}</#if>"
                />
            </div>

            <textarea id="editor-textarea" onkeydown="counter(16)" onkeyup="counter(16)" class="form-control
                      ${(textError??)?string('is-invalid', '')}" name="text" rows="16"
                      style="overflow:hidden"
                      placeholder="Напишите статью"><#if article??>${article.text}</#if></textarea>
            <#if textError??>
                <div class="invalid-feedback">
                ${textError}
                </div>
            </#if>
            <br/>

            <button class="btn btn-primary" type="submit">Save</button>

            <#--<!-- Large modal &ndash;&gt;-->
            <#--<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">-->
                <#--Preview-->
            <#--</button>-->

            <#--<!-- Modal &ndash;&gt;-->
            <#--<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"-->
                 <#--aria-hidden="true">-->
                <#--<div class="modal-dialog modal-lg">-->
                    <#--<div class="modal-content">-->
                        <#--<div class="modal-header">-->
                            <#--<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>-->
                            <#--<button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
                                <#--<span aria-hidden="true">&times;</span>-->
                            <#--</button>-->
                        <#--</div>-->
                        <#--<div class="modal-footer">-->
                            <#--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
                            <#--<button class="btn btn-primary" type="submit">Save</button>-->
                        <#--</div>-->
                        <#--<div class="modal-body">-->
                            <#--<div class="container-fluid">-->
                                <#--... TODO ...-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="modal-footer">-->
                            <#--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
                            <#--<button class="btn btn-primary" type="submit">Save</button>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->

            </div>
            </form>
        </div>

        <div class="form-group col-md-7">
            <pre id="editor-result"></pre>
        </div>
    </div>


</div>
<script type="text/javascript" src="/static/js/script.js"></script>
</@common.page>