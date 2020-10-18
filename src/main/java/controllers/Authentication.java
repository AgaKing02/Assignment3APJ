package controllers;

import models.User;
import services.UserService;
import services.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "controllers.Authentication")
public class Authentication extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name, String surname, String username, String password, Date birthday, String role
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        User user = new User();
        user.setName(request.getParameter("txtName"));
        user.setUsername(request.getParameter("txtUsername"));
        user.setSurname(request.getParameter("txtSurname"));
        user.setPassword(request.getParameter("txtPassword"));
        user.setBirthday(sqlDate);
        user.setRole("USER");
        userService.addUser(user);
        response.sendRedirect(request.getContextPath()+"/login");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}
