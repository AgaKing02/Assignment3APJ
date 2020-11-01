package kz.edu.astanait.controllers;

import kz.edu.astanait.interfaces.BookRepository;
import kz.edu.astanait.interfaces.OrderRepository;
import kz.edu.astanait.models.*;
import kz.edu.astanait.repository.BookRepositoryImpl;
import kz.edu.astanait.repository.OrderRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Cart")
public class Cart extends HttpServlet {
    private final OrderRepository orderRepository=new OrderRepositoryImpl();
    private final BookRepository bookRepository=new BookRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            response.sendRedirect(request.getContextPath()+"/login");
        }

        HttpSession session = request.getSession();
        CartBook cartBook=null;
        if (session.getAttribute("cartProducts") != null) {
            cartBook = (CartBook) session.getAttribute("cartProducts");
        }else{
            response.sendRedirect(request.getContextPath()+"/main");
        }
        assert cartBook != null;
        List<Book> ordered=cartBook.getBookList();
        String finalUsername = username;
       ordered.forEach(e->orderRepository.add(new Order(finalUsername,e.getIsbn())));
       ordered.forEach(bookRepository::addReader);

        response.sendRedirect(request.getContextPath()+"/order");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cartProducts") != null) {
            CartBook myProducts = (CartBook) session.getAttribute("cartProducts");
            request.setAttribute("books", myProducts.getBookList());
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        } else {
            PrintWriter printWriter = response.getWriter();
            response.setContentType("text/html");
            printWriter.print("No cart items<br>");
        }

    }
}
