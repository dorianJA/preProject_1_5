<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Edit user!</h2>
<form action="/admin/edit" method="post">
<%--    <table border="1px">--%>
<%--        <tr>--%>
<%--            <th>Name</th>--%>
<%--            <th>Age</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="user" items="${editUser}" >--%>
<%--            <tr>--%>
<%--                <th>${user.name}</th>--%>
<%--                <th>${user.age}</th>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

    <li>
        <label>Name:</label>
        <input type="text" name="name" value=${userData.name} size="15">
    </li>
    <li>
        <label>Age: </label>
        <input type="number" name="age" value=${userData.age} size="15">
    </li>
    <br>
    <input type="submit" name="editUser" size="10" value="Изменить пользователя">
    <input type="hidden" name="idValue" value="<%= request.getParameter("idValue") %>"/>
</form>
</body>
</html>
