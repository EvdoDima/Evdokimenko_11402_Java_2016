<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">${tablename?capitalize}</div>
        <div class="panel-body">
            <table data-toggle="table">
                <thead>
                <tr>
                <#list tableheader as th>
                    <th data-field="${th}">${th}</th>
                </#list>

                <#if tablename == "applications">
                    <@security.authorize ifAnyGranted="ROLE_DRIVER">
                        <th>
                            Car select
                        </th>
                    </@security.authorize>
                </#if>


                </tr>
                </thead>
                <tbody>
                <#list tablebody as tb>
                <tr>
                    <#list tb as content>
                        <td>${content}</td>
                    </#list>

                    <#if tablename == "applications">
                        <@security.authorize ifAnyGranted="ROLE_DRIVER">
                            <#if cars?has_content>
                                <form role="form" action="/tables/orders/new" method="post">
                                    <td>
                                        <select class="form-control" name="carmodel">
                                            <#list cars as c>
                                                <option>${c.model}</option>
                                            </#list>
                                        </select>
                                    </td>

                                    <td>
                                        <button class="btn btn-primary" type="submit">Get the order</button>

                                    </td>
                                    <input type="hidden" name="appid" value="${tb[0]}">
                                </form>
                            <#else>
                                <td>
                                    <b>No free cars</b>
                                </td>
                            </#if>
                        </@security.authorize>
                    </#if>

                    <#if tablename == "orders" && tb[1]=="Processing">
                        <td>
                            <@security.authorize ifAnyGranted="ROLE_DRIVER">
                                <form role="form" action="/tables/orders" method="post">
                                    <input type="hidden" name="orderid" value="${tb[0]}">
                                    <button type="submit" class="btn btn-primary">Completed</button>
                                </form>
                            </@security.authorize>
                        </td>
                    </#if>


                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>


<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/bootstrap-table.js"></script>
