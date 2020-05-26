package servlets;

import Util.DBConnection;
import dao.UserDaoImp;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/doServlet")
public class AssignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String add = "add";
        String edit = "edit";
        String del = "delete";
        if (request.getParameter("allUsers") == null && add.equals(request.getParameter("Add"))) {
            response.sendRedirect("AddForm.jsp");
        } else if (request.getParameter("allUsers") == null && del.equals(request.getParameter("Delete"))) {
            response.sendRedirect("main");
        } else if (request.getParameter("allUsers") == null && edit.equals(request.getParameter("Edit"))) {
            response.sendRedirect("main");
        } else {
            String usersParam = request.getParameter("allUsers");

            if (add.equals(request.getParameter("Add"))) {
                System.out.println("This is add");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddForm.jsp");
                requestDispatcher.forward(request, response);
            } else if (edit.equals(request.getParameter("Edit")) && !usersParam.isEmpty()) {
                System.out.println("This is edit");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("EditForm.jsp");
                requestDispatcher.forward(request, response);
            } else if (del.equals(request.getParameter("Delete")) && !usersParam.isEmpty()) {
                System.out.println("This is delete");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/deleteServlet");
                requestDispatcher.forward(request, response);
            }
        }
    }

}
