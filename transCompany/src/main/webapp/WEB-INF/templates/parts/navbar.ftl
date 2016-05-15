<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="#"><span>TransCompany</span></a>
            <ul class="user-menu">
                <@security.authorize access="isAuthenticated()">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <svg class="glyph stroked male-user">
                            <use xlink:href="#stroked-male-user"></use>
                        </svg>
                        User <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">

                        <li><a href="/user/logout">
                            <svg class="glyph stroked cancel">
                                <use xlink:href="#stroked-cancel"></use>
                            </svg>
                            Logout</a></li>
                    </ul>
                </li>
                </@security.authorize>
            </ul>
        </div>

    </div><!-- /.container-fluid -->
</nav>
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