<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stephencisler
  Date: 12/20/17
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ad List"/>
    </jsp:include>
</head>
<body>

    <jsp:include page="../partials/navbar.jsp"></jsp:include>

    <h1 class="text-center">Welcome to the Ad List!</h1>

    <div class="container">
        <%-- forEaching to write html for each add, make sure the variable is something you can iterate over--%>
        <div class="row">
            <c:forEach var="ad" items="${ads}">
                <div class="col-xs-6 col-md-4">
                    <h3><span>${ad.id}</span>: ${ad.title}</h3>
                    <p>${ad.description}</p>
                </div>
            </c:forEach>
        </div>
    </div>

</body>
</html>
