package controllers;

import interfaces.OrderRepository;
import models.CartProducts;
import models.Order;
import models.Product;
import repository.OrderRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Cart")
public class Cart extends HttpServlet {
    private final OrderRepository orderRepository=new OrderRepositoryImpl();
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
        CartProducts myProducts=null;
        if (session.getAttribute("cartProducts") != null) {
            myProducts = (CartProducts) session.getAttribute("cartProducts");
        }else{
            response.sendRedirect(request.getContextPath()+"/main");
        }
        assert myProducts != null;
        List<Product> ordered=myProducts.getProductList();
        String finalUsername = username;
        for (Product product:ordered) {
            orderRepository.add(new Order(username,product.getID()));
        }
        response.sendRedirect(request.getContextPath()+"/order");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cartProducts") != null) {
            CartProducts myProducts = (CartProducts) session.getAttribute("cartProducts");
            System.out.println(myProducts.toString());
            request.setAttribute("products", myProducts.getProductList());
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        } else {
            PrintWriter printWriter = response.getWriter();
            response.setContentType("text/html");
            printWriter.print("No cart items<br>");
        }

    }
}
