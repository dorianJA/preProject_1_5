
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h2>Add user</h2>
<form action="/addServlet" method="post">
    <li>
        <label>Name:</label>
        <input type="text" name="name" size="15">
    </li>
    <li>
        <label>Age: </label>
        <input type="number" name="age" size="15">
    </li> <br>
    <input type="submit" name="addUser" size="10" value="Добавить пользователя">
</form>
</body>
</html>
