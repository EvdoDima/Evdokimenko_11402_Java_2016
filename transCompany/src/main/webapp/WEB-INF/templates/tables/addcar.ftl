<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Car adding</title>

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
            <div class="panel-heading"><h3>New car adding</h3></div>
            <div class="panel-body">
                <div class="col-lg-6">
                <@sf.form class="form-horizontal" action="/tables/cars/new" method="post" modelAttribute="regform">
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
