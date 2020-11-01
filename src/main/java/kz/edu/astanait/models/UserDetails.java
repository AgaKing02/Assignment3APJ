package kz.edu.astanait.models;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDetails {
    public static void isAuthenticated(HttpServletRequest request, HttpServletResponse response){
        String username=null;
        Cookie[] cookies =request.getCookies();
        //Displaying User name value from cookie
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
                username=cookie.getValue();
                break;
            }
        }
        if(username==null){
            try {
                response.sendRedirect(request.getContextPath()+"/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
