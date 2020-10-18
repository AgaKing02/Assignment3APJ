package controllers;

import models.User;
import models.UserLoginData;
import services.UserService;
import services.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "controllers.Authorization")
public class Authorization extends HttpServlet {
    private final UserService userService=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserLoginData userLoginData=new UserLoginData(request.getParameter("txtUsername"),request.getParameter("txtPassword"));
        if(checkUserExistence(userLoginData)){
            Cookie cookie=new Cookie("username",userLoginData.getUsername());
            Main.iHitCounter++;
            response.addCookie(cookie);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.print("<h1><a href='"+request.getContextPath()+"/profile'>Confirm "+userLoginData.getUsername()+" user </a></h1>");
        }else {
            response.sendRedirect("/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    public boolean checkUserExistence(UserLoginData userLoginData){
        User user=userService.checkUserExistence(userLoginData);
        return user != null;
    }
}
