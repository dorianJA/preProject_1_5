
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Edit user</h2>
<form action="/editServlet" method="post">
    <li>
        <label>Name:</label>
        <input type="text" name="name" size="15">
    </li>
    <li>
        <label>Age: </label>
        <input type="number" name="age" size="15">
    </li> <br>
    <input type="submit" name="editUser" size="10" value="Изменить пользователя">
    <input type="hidden" name="idValue" value="<%= request.getParameter("allUsers") %>" />
</form>
</body>
</html>
