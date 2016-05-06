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


<@sf.form class="form-horizontal" action="/user/register" method="post" modelAttribute="regform">
<div class="row">
<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
<div class="login-panel panel panel-default">
    <div class="panel-heading">Registration</div>
<div class="panel-body">
<form role="form" action="/user/register">
<fieldset>
<div class="form-group">
    <@sf.input path="login" type="text" class="form-control" name = "login" placeholder="Login"/>
    <@sf.errors path="login" class="panel-heading
						Danger Panel"/>

    </div>
        <div class="form-group">
            <@sf.input path="password" type="password" class="form-control" name = "password" placeholder="Password"/>
                        <@sf.errors path="password" class="panel-heading
						Danger Panel"/>

        </div>
        <div class="form-group">
            <@sf.input path="repassword" type="password" class="form-control" name = "repassword" placeholder="Repeat the password"/>
                        <@sf.errors path="repassword" class="panel-heading
						Danger Panel"/>
        </div>

        <div  align="center">
            Role:
            <@sf.radiobutton path="userrole"  name="userrole" value="ROLE_DRIVER" checked="checked"/>Driver
            <@sf.radiobutton path="userrole"   name="userrole" value="ROLE_CUSTOMER"/>Customer
        </div>

        <button class="btn btn-primary" type="submit">Register</button>
    </fieldset>
    </form>
    </div>
    </div>
    </div><!-- /.col-->
    </div><!-- /.row -->
    </@sf.form>


<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/chart.min.js"></script>
<script src="/resources/js/chart-data.js"></script>
<script src="/resources/js/easypiechart.js"></script>
<script src="/resources/js/easypiechart-data.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<script>
    !function ($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    });
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>
