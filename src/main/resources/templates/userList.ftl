<#import "parts/common.ftl" as common>

<@common.page>

    <h3>List of users</h3>

    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Role</th>
                <th scope="col"></th>
            </tr>
        </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td scope="row">${user.id}</td>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>
                        ${role}<#sep>, </#list>
                    </td>
                    <td>
                        <a href="/user/${user.id}">
                            edit
                        </a>
                    </td>
                </tr>
            </#list>
            </tbody>
    </table>

</@common.page>