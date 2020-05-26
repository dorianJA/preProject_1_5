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

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String id = request.getParameter("idValue");
        if (checkData(name, age)) {
            try {
                User user = userService.getUserbyId(Long.parseLong(id));
                userService.updateUser(user, Integer.parseInt(age), name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/main");
    }

    private boolean checkData(String name, String age) {
        return (!name.isEmpty() && !age.isEmpty() && name.matches("[a-zA-Z]+") && age.matches("\\d+"));
    }
}
