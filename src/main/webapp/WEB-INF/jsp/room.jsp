<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to chat!</title>

</head>
<body>
<h1>Hello, <c:out value="${userName}"></c:out>!</h1><br/>

<div class="form">

    <h2>Message History</h2>

    <c:forEach var="message" items="${messages}">
        <ul>
            <li><c:out value="${message.user.login}"/> <c:out value="${message.text}"/></li>
        </ul>
        <hr />
    </c:forEach>

    <h2>Send a message</h2>
    <form method="post" action="message">

        <input type="text" required placeholder="text" name="text"><br>
        <input type="text" hidden name="login" value="${login}">

        <input class="button" type="submit" value="text">

    </form>

</div>

</body>
</html>
