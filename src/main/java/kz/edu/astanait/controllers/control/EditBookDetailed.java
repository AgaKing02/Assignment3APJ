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

@WebServlet(name = "EditBookDetailed")
public class EditBookDetailed extends HttpServlet {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final BookRepository bookRepository = new BookRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book(
                Integer.parseInt(request.getParameter("bookisbn")),
                StringConfigurerFunctions.replaceWhiteSpaceWithMinus(request.getParameter("bookname")),
                StringConfigurerFunctions.replaceWhiteSpaceWithMinus(request.getParameter("bookauthor")),
                request.getParameter("bookimage"),
                Integer.parseInt(request.getParameter("bookstock")));
        bookRepository.update(book);
        response.sendRedirect(request.getContextPath()+"/books");

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
        } else {
            int bookid = Integer.parseInt(request.getParameter("id"));
            Book book = bookRepository.getBookByIsbn(bookid);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/editdetailed.jsp").forward(request, response);

        }
    }
}
