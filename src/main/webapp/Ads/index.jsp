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
    <title>Title</title>
</head>
<body>

    <h1>Welcome to the Ad List!</h1>

    <div class="container">

        <%-- forEaching to write html for each add --%>
        <c:forEach var="ad" items="${ads}">
                <h2>${ad.id}</h2>
                <h3>${ad.title}</h3>
                <p>${ad.description}</p>
        </c:forEach>

    </div>

</body>
</html>
