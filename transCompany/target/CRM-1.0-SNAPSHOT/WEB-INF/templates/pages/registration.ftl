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
            <div class="panel-heading">Registration</div>
            <div class="panel-body">
                <div class="col-lg-6">
                <@sf.form class="form-horizontal" action="/user/register/customer" method="post" modelAttribute="regform">

                    <form role="form">
                        <fieldset>
                            <div class="form-group">
                                <@sf.input path="login" type="text" class="form-control" name = "login" placeholder="Login"/>
                            <@sf.errors path="login" style="color :red"/>

                            </div>

                            <div class="form-group">
                                <@sf.input path="name" type="text" class="form-control" name = "name" placeholder="Name"/>
                            <@sf.errors path="name" style="color :red"/>
                            </div>

                            <div class="form-group">
                                <@sf.input path="lastname" type="text" class="form-control" name = "lastname" placeholder="Last Name"/>
                        <@sf.errors path="lastname" style="color :red"/>
                            </div>

                            <div class="form-group">
                                <@sf.input path="telnumber" type="number" class="form-control" name = "telnumber" placeholder="tel number"/>
                        <@sf.errors path="telnumber" style="color :red"/>
                            </div>


                            <div class="form-group">
                                <@sf.input path="password" type="password" class="form-control" name = "password" placeholder="Password"/>
                        <@sf.errors path="password" style="color :red"/>
                            </div>


                            <div class="form-group">
                                <@sf.input path="repassword" type="password" class="form-control" name = "repassword" placeholder="Repeat the password"/>
                        <@sf.errors path="repassword" style="color :red"/>
                            </div>

                            <button class="btn btn-primary" type="submit">Register</button>
                        </fieldset>
                    </form>
                </@sf.form>
                </div>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->

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
