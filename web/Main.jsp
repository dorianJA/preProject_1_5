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

<html>
<head>
    <title>Testing</title>
</head>
<body>

<h2>Список пользователей</h2>
<form action="/admin/crud" method="get">
    <select name="allUsers"  size="16">
        <%
            List<User> list = null;
            try {
                list = UserService.getInstance().getAllUsers();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            for(User user: list) {
                out.println("<option value=" + "'" + user.getId() + "'" + ">" + user.getName() + " "+user.getAge()+ "</option>");
            }
        %>

    </select> <br>
    <input type="submit" name="Add" value="add"> <br>
    <input type="submit" name="Edit" value="edit"> <br>
    <input type="submit" name="Delete" value="delete"> <br>
</form>


</body>
</html>
