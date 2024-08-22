package org.example.logindemojsp.Controller;

import org.example.logindemojsp.DAO.UserDAO;
import org.example.logindemojsp.DatabaseConnection;
import org.example.logindemojsp.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


public class ForgotPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            UserDAO userDAO = new UserDAO(DatabaseConnection.getConnection());
            User user = userDAO.getUserByEmail(email);

            if (user != null) {
                String token = UUID.randomUUID().toString();
                // Gửi email với token

                request.setAttribute("message", "Check your email to reset your password");
            } else {
                request.setAttribute("errorMessage", "Email not found");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("forgot_password.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}