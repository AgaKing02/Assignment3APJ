package kz.edu.astanait.controllers.control;

import kz.edu.astanait.interfaces.BookRepository;
import kz.edu.astanait.interfaces.UserRepository;
import kz.edu.astanait.models.User;
import kz.edu.astanait.repository.BookRepositoryImpl;
import kz.edu.astanait.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditBook")
public class EditBook extends HttpServlet {
    private final BookRepository bookRepository = new BookRepositoryImpl();
    private final UserRepository userRepository=new UserRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        }else {
            request.setAttribute("books", bookRepository.getAllBooks());
            request.getRequestDispatcher("/editbook.jsp").forward(request, response);
        }

    }
}
