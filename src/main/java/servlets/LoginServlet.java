package servlets;

import dao.UserDaoFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = UserService.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            User user = userService.getUserByNameAndPassword(name, password);
            if (user == null) {
                response.sendRedirect("/login");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (user.getRole().equals("user")) {
                    response.getWriter().print("Welcome User " + user.getName());
                } else {
                    response.getWriter().print("Welcome Admin " + user.getName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
