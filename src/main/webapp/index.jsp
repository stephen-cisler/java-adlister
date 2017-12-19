<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "some title" %></title>
    <%@ include file="partials/head.jsp"%>
</head>
<body id="page-top">
    <%@ include file="partials/nav.jsp" %>
    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">The Journey of Learning JPS and JSTL</h1>
                <hr>
                <p>It's difficult to grasp at first!</p>
                <a href="/login.jsp" class="btn btn-primary btn-xl page-scroll">Login</a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Or if you want to jump stright to the profile!</h2>
                    <hr class="light">
                    <p class="text-faded">Oh boy, here we go!</p>
                    <a href="/profile.jsp" class="page-scroll btn btn-default btn-xl sr-button">Profile Time!</a>
                </div>
            </div>
        </div>
    </section>

<%@include file="partials/scripts.jsp"%>
</body>
</html>
