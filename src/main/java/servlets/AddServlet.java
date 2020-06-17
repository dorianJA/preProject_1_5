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

@WebServlet("/admin/add")
public class AddServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        if (checkData(name, age,password,role)) {
            User user = new User(Integer.parseInt(age), name,password,role);
            try {
                userService.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/admin");
        }else {
            response.sendRedirect("/admin");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/AddForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    private boolean checkData(String name, String age, String pass, String role) {
        return (!name.isEmpty() && !age.isEmpty() && !pass.isEmpty() && !role.isEmpty() &&
                name.matches("[a-zA-Zа-яА-Я]+") && age.matches("\\d+"));
    }
}
