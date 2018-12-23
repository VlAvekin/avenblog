<#import "parts/common.ftl" as common>

<@common.page>

    <h5>${username}</h5>
    ${articles?ifExists}

        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Password : </label>
                <div class="col-sm-6">
                    <input type="password" name="password" class="form-control" placeholder="Password"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Email : </label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="Email"
                    value="${email!''}"/>
                </div>
            </div>

            <div class="form-group row">
                <button type="submit" class="btn btn-primary">
                Save
                </button>
            </div>

        </form>

    <#include "parts/footer.ftl">
</@common.page>