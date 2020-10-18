package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.Profile")
public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies =request.getCookies();
        //Displaying User name value from cookie
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
                cookie.setMaxAge(0);
                cookie.setValue("");
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath()+"/login");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean userExistence=false;
        Cookie[] cookies =request.getCookies();
        //Displaying User name value from cookie
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
              request.setAttribute("username",cookie.getValue());
              userExistence=true;
            }
        }
        if(userExistence){
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
