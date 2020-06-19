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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/edit")
public class EditServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    private List<User> list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String id = request.getParameter("idValue");
        if (checkData(name, age)) {
            try {
                User user = userService.getUserById(Long.parseLong(id));
                userService.updateUser(user, Integer.parseInt(age), name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/admin");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idValue");
        try {
            User user = userService.getUserById(Long.parseLong(id));
            req.setAttribute("userData",user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/EditForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    private boolean checkData(String name, String age) {
        return (!name.isEmpty() && !age.isEmpty() && name.matches("[a-zA-Z]+") && age.matches("\\d+"));
    }
}
