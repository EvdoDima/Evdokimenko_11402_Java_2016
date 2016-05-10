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


<@sf.form class="form-horizontal" action="/tables/cars/new" method="post" modelAttribute="regform">
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-danger"><h3>New car adding</h3></div>
            <div class="panel-body">
                <form role="form">
                    <fieldset>

                        <div class="form-group">
                            <@sf.input path="model" type="text" class="form-control" name = "model" placeholder="Model"/>
                            <@sf.errors path="model" class="panel-danger"/>
                        </div>

                        <div class="form-group">
                            <label>Year of pruduction</label>
                            <@sf.input path="year" type = "number"  class="form-control" name = "year" placeholder="Year"/>
                            <@sf.errors path="year" class="panel-danger"/>
                        </div>



                        <div class="form-group">
                            <label>Run</label>
                            <@sf.input path="run" type="number" class="form-control" name = "run" placeholder="Run"/>
                        <@sf.errors path="run" class="panel-danger"/>
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
