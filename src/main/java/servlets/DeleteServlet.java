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

@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String[] id = req.getParameterValues("del");
        if(id !=null ) {
            for (String str : id) {
                try {
                    User user = userService.getUserById(Long.parseLong(str));
                    userService.deleteUser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            resp.sendRedirect("/admin");
        }else {
            resp.sendRedirect("/admin");
        }
    }
}
