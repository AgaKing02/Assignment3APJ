package kz.edu.astanait.controllers;//import kz.edu.astanait.services.implementations.UserServiceImpl;
//import kz.edu.astanait.services.UserService;

import kz.edu.astanait.interfaces.BookRepository;
import kz.edu.astanait.models.Book;
import kz.edu.astanait.repository.BookRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@WebServlet(name = "kz.edu.astanait.controllers.Main")
public class Main extends HttpServlet {
    public static int iHitCounter;
    private final BookRepository bookRepository = new BookRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("reqValue"));
//        if (productService.getProductById(id) != null) {
//            productService.deleteFood(id);
//        }
        response.sendRedirect(request.getContextPath() + "/main");

    }

    public void init() throws ServletException {
        iHitCounter = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookRepository.getAllBooks();
        List<String> authors = bookRepository.getAuthors();
        if (request.getParameter("sort_by") != null)
            Collections.sort(bookList);
        request.setAttribute("books", bookList);
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
