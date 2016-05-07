
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">${tablename?capitalize}</div>
        <div class="panel-body">
            <table data-toggle="table">
                <thead>
                <tr>
                <#list tableheader as th>
                    <th data-field="${th}" >${th}</th>
                </#list>
                <#--<th data-field="state" data-checkbox="true">Item ID</th>-->
                <#--<th data-field="id" data-sortable="true">Item ID</th>-->
                <#--<th data-field="name" data-sortable="true">Item Name</th>-->
                <#--<th data-field="price" data-sortable="true">Item Price</th>-->
                </tr>
                </thead>
                <tbody>
                <#list tablebody as tb>
                <tr>
                    <#list tb as content>
                        <td>${content}</td>
                    </#list>

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
