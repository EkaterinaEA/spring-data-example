<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your login is wrong!</title>

</head>
<body>

<div class="form">

    <h2>Input your login, please!</h2>
    <form method="post" action="authorization">

        <input type="text" required placeholder="login" name="login"><br>
        <input class="button" type="submit" value="Login">

    </form>
</div>
</body>
</html>