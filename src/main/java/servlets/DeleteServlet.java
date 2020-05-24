package servlets;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    UserService userService = new UserService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("allUsers");

        try {
            userService.deleteUser(Long.parseLong(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/main");
    }
}
