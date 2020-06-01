package servlets;

import model.User;
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
    UserService userService = UserService.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("allUsers");


        try {
            User user = userService.getUserbyId(Long.parseLong(id));
            userService.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/main");
    }
}
