package servlets;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = null;
        try {
            list = UserService.getInstance().getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Main.jsp");
        requestDispatcher.forward(request, response);
    }
}
