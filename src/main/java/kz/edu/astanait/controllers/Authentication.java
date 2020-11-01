package kz.edu.astanait.controllers;

import kz.edu.astanait.interfaces.UserRepository;
import kz.edu.astanait.models.User;
import kz.edu.astanait.repository.UserRepositoryImpl;
import kz.edu.astanait.services.UserService;
import kz.edu.astanait.services.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "kz.edu.astanait.controllers.Authentication")
public class Authentication extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final UserRepository userRepository=new UserRepositoryImpl();

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
        if(userRepository.getUserByUsername(user.getUsername())!=null){
            response.sendRedirect(request.getContextPath()+"/login?error=duplicate");
        }else{
            userService.addUser(user);
            response.sendRedirect(request.getContextPath()+"/login");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies =request.getCookies();
        String role = null;
        //Displaying User name value from cookie
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
                User user=userRepository.getUserByUsername(cookie.getValue());
                role=user.getRole();
            }
        }
        if(!role.equals("ADMIN")){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}
