<%--
  Created by IntelliJ IDEA.
  User: malenchev
  Date: 02.06.2020
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <li>
        <label>login:</label>
        <input type="text" name="name" size="15">
    </li>
    <li>
        <label>password: </label>
        <input type="password" name="password" size="15">
    </li>
    <br>
    <input type="submit" name="login" size="10" value="Войти">
</form>
</body>
</html>
