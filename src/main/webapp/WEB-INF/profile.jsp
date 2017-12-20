<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing your profile.</h1>
        <h2>Welcome, ${name}.</h2>
        <p>Current E-mail: <em>${email}</em></p>
    </div>

    <form action="/logout" method="POST">
        <button type="submit">LOGOUT</button>
    </form>

</body>
</html>
