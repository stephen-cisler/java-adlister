<%--
  Created by IntelliJ IDEA.
  User: stephencisler
  Date: 12/18/17
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%! int counter = 1; %>
    <% counter += 1; %>
<c:if test="${usernameLogin.equals('admin')}">

</c:if>


<html>
<head>
    <title>Login Page</title>
    <%@ include file="partials/head.jsp"%>
</head>
<body id="page-top">
    <%@ include file="partials/nav.jsp" %>

    <div class="container" style="padding-top: 80px">
        <form method="post" action="login.jsp">
            <div class="form-group">
                <label for="usernameLogin">Username</label>
                <input name="usernameLogin" type="email" class="form-control" id="usernameLogin" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-default">Login</button>
        </form>
    </div>

    <h2>Times page has been visited: <%= counter%></h2>


    <%@ include file="partials/scripts.jsp" %>
</body>
</html>
