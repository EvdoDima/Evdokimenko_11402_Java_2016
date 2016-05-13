<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "navbar.ftl">

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li class="active"><a href="/">
            <svg class="glyph stroked dashboard-dial">
                <use xlink:href="#stroked-dashboard-dial"></use>
            </svg>
            Dashboard</a></li>

    <@security.authorize ifAnyGranted="ROLE_CUSTOMER">
        <li><a href="/tables/applications/new">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-table"></use>
            </svg>
            New application</a></li>
    </@security.authorize>



    <@security.authorize ifAnyGranted="ROLE_DRIVER">
        <li><a href="/tables/orders">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-map"></use>
            </svg>
            My orders</a></li>
    </@security.authorize>

    <@security.authorize ifAnyGranted="ROLE_ADMIN">
        <li><a href="/tables/cars/new">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-map"></use>
            </svg>
            Add Car</a></li>
    </@security.authorize>


    <@security.authorize ifAnyGranted="ROLE_ADMIN">
        <li><a href="/user/register/driver">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-male-user"></use>
            </svg>
            Register new Driver</a></li>
    </@security.authorize>


    <@security.authorize ifAnyGranted="ROLE_CUSTOMER,ROLE_DRIVER,ROLE_ADMIN">
        <li><a href="/tables/cars">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-map"></use>
            </svg>
            Cars</a></li>
    </@security.authorize>

    <@security.authorize ifAnyGranted="ROLE_CUSTOMER,ROLE_ADMIN">
        <li><a href="/tables/drivers">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-map"></use>
            </svg>
            Drivers</a></li>
    </@security.authorize>

    <@security.authorize ifAnyGranted="ROLE_ADMIN">
        <li><a href="/tables/customers">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-table"></use>
            </svg>
            Customers</a></li>
    </@security.authorize>

<@security.authorize ifAnyGranted="ROLE_ADMIN,ROLE_DRIVER">
    <li><a href="/tables/applications">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-table"></use>
            </svg>
            Applications</a></li>
</@security.authorize>


    <@security.authorize ifAnyGranted="ROLE_ADMIN">
        <li><a href="/tables/orders">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-table"></use>
            </svg>
            Orders</a></li>
    </@security.authorize>

    <@security.authorize ifAnyGranted="ROLE_ADMIN">
        <li><a href="/tables/messages">
            <svg class="glyph stroked table">
                <use xlink:href="#stroked-table"></use>
            </svg>
            Messages</a></li>
    </@security.authorize>


<@security.authorize access="! isAuthenticated()">
        <li role="presentation" class="divider"></li>
        <li><a href="/user/login">
            <svg class="glyph stroked male-user">
                <use xlink:href="#stroked-male-user"></use>
            </svg>
            Login Page</a></li>
</@security.authorize>

<@security.authorize access="! isAuthenticated()">
    <li><a href="/user/register/customer">
        <svg class="glyph stroked male-user">
            <use xlink:href="#stroked-male-user"></use>
        </svg>
        Registration</a></li>
</@security.authorize>
        </ul>

</div>