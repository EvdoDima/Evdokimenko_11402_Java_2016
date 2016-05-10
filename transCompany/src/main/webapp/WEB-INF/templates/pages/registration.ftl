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



<@sf.form class="form-horizontal" action="/user/register/customer" method="post" modelAttribute="regform">
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-danger">Registration</div>
            <div class="panel-body">
                <form role="form">
                    <fieldset>
                        <div class="form-group">
                            <@sf.input path="login" type="text" class="form-control" name = "login" placeholder="Login"/>
                            <@sf.errors path="login" class="panel-danger"/>
                        </div>

                        <div class="form-group">
                            <@sf.input path="name" type="text" class="form-control" name = "name" placeholder="Name"/>
                            <@sf.errors path="name" class="panel-danger"/>
                        </div>

                        <div class="form-group">
                            <@sf.input path="lastname" type="text" class="form-control" name = "lastname" placeholder="Last Name"/>
                        <@sf.errors path="lastname" class="panel-danger"/>
                        </div>

                        <div class="form-group">
                            <@sf.input path="telnumber" type="number" class="form-control" name = "telnumber" placeholder="tel number"/>
                        <@sf.errors path="telnumber" class="panel-danger"/>
                        </div>


                        <div class="form-group">
                            <@sf.input path="password" type="password" class="form-control" name = "password" placeholder="Password"/>
                        <@sf.errors path="password" class="panel-danger"/>
                        </div>


                        <div class="form-group">
                            <@sf.input path="repassword" type="password" class="form-control" name = "repassword" placeholder="Repeat the password"/>
                        <@sf.errors path="repassword" class="panel-danger"/>
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
