package kz.edu.astanait.controllers.control;

import kz.edu.astanait.interfaces.BookRepository;
import kz.edu.astanait.interfaces.UserRepository;
import kz.edu.astanait.models.Book;
import kz.edu.astanait.models.StringConfigurerFunctions;
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

@WebServlet(name = "AddBook")
public class AddBook extends HttpServlet {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final BookRepository bookRepository = new BookRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book addedBook = new Book(
                StringConfigurerFunctions.replaceWhiteSpaceWithMinus(request.getParameter("bookname")) ,
                StringConfigurerFunctions.replaceWhiteSpaceWithMinus(request.getParameter("bookauthor")) ,
                request.getParameter("bookimage"),
                Integer.parseInt(request.getParameter("bookstock"))
        );

        if(bookRepository.getBookByName(addedBook.getName())!=null){
            response.sendRedirect(request.getContextPath()+"/books?error=alreadyexists");
        }else{
            bookRepository.add(addedBook);
            response.sendRedirect(request.getContextPath()+"/books");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String role = null;
        //Displaying User name value from cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                User user = userRepository.getUserByUsername(cookie.getValue());
                role = user.getRole();
            }
        }
        if (!role.equals("ADMIN")) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        request.getRequestDispatcher("/addbook.jsp").forward(request, response);
    }
}
