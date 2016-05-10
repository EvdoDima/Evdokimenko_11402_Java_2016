<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/datepicker3.css" rel="stylesheet">
    <link href="/resources/css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>


<@sf.form class="form-horizontal" action="/tables/applications/new" method="post" modelAttribute="regform">
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-danger">Registration</div>
            <div class="panel-body">
                <form role="form">
                    <fieldset>
                        <#if error??>
                            <div class="alert alert-danger text-center">Name is busy</div>
                        </#if>
                        <div class="form-group">
                            <@sf.input path="name" type="text" class="form-control" name = "name" placeholder="Name"/>
                            <@sf.errors path="name" class="panel-danger"/>
                        </div>

                        <div class="form-group">
                            <@sf.textarea path="description" rows = "5" class="form-control"  name = "description" placeholder="Description"/>
                            <@sf.errors path="description" class="panel-danger"/>
                        </div>



                        <div class="form-group">
                            <@sf.input path="summ" type="number" class="form-control" name = "summ" placeholder="Summ"/>
                        <@sf.errors path="summ" class="panel-danger"/>
                        </div>



                         <button class="btn btn-primary" type="submit">Register</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->
</@sf.form>

</body>

</html>
