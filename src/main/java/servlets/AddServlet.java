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

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    UserService userService = UserService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        if (checkData(name, age)) {
            User user = new User(Integer.parseInt(age), name);
            try {
                userService.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("main");
        }
    }


    private boolean checkData(String name, String age) {
        return (!name.isEmpty() && !age.isEmpty() && name.matches("[a-zA-Z]+") && age.matches("\\d+"));
    }
}
