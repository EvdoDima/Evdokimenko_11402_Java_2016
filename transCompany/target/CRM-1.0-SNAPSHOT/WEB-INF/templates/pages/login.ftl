<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/datepicker3.css" rel="stylesheet">
    <link href="/resources/css/styles.css" rel="stylesheet">

    <!--Icons-->
    <script src="/resources/js/lumino.glyphs.js"></script>

    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.min.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->

</head>


<body>
<#include "../parts/navbar.ftl">

<#include "../parts/sidebar.ftl">

<div class="row" style="margin-top: 50px">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">Log in</div>
            <div class="panel-body">
                    <form role="form" action="/user/login/process" method="post" class="form-group">
                        <fieldset>
                        <#if error??>
                            <div class="alert alert-danger text-center">Authentication failed</div>
                        </#if>
                            <div class="form-group">
                                <input class="form-control" placeholder="Login" name="login" type="text" autofocus="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password"
                                       value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember-me" type="checkbox" value="true">Remember Me
                                </label>
                            </div>
                            <button class="button" type="submit">Login</button>
                            <div class="form-group">
                                <a class="button" href="/user/register/customer">Regisration</a>
                            </div>
                        </fieldset>
                    </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!--
 /.row -->

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