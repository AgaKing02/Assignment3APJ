package kz.edu.astanait.controllers;

import kz.edu.astanait.interfaces.BookRepository;
import kz.edu.astanait.models.*;
import kz.edu.astanait.repository.BookRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "Confirmation")
public class Confirmation extends HttpServlet {
    private final BookRepository bookRepository=new BookRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        boolean check=false;
        for (Cookie cookie :cookies){
            if(cookie.getName().equals("username")){
             check=true;
            }

        }
        if(check){
            List<Book> confirmed=new ArrayList<>();

            String[] products = request.getParameterValues("products");
            List<String> productList = Arrays.asList(products);

            productList.forEach(e->confirmed.add(bookRepository.getBookByName(e)));

            HttpSession session = request.getSession();
            session.setAttribute("cartProducts",new CartBook(confirmed));
            session.setMaxInactiveInterval(5*60);
            response.sendRedirect(request.getContextPath()+"/cart");


        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
