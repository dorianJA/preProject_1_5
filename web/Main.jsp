<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ page import="org.apache.catalina.connector.Request" %>
<%@ page import="org.apache.catalina.Context" %><%--

--%>
<%@ page import="model.User" %>
<%@ page import="service.UserService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Testing</title>
</head>
<body>

<h2>Список пользователей</h2>
<form action="/admin/delete" method="post">
    <table border="1px">
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>role</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.age}"></c:out></td>
                <td><c:out value="${user.role}"></c:out></td>
                <td>
                    <a href="/admin/edit?idValue=<c:out value='${user.id}' />">Edit</a>
                </td>
                <td>
                    <input type="checkbox" name="del" value=${user.id}>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" name="Delete" value="delete"> <br>
</form>
<form action="/admin/add">
    <input type="submit" value="add"> <br>
</form>


</body>
</html>
