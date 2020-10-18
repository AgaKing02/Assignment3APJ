package controllers;

import models.CartProducts;
import models.Product;
import services.ProductService;
import services.implementations.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Confirmation")
public class Confirmation extends HttpServlet {
    private final ProductService productService=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        boolean check=false;
        for (Cookie cookie :cookies){
            if(cookie.getName().equals("username")){
             check=true;
            }

        }
        if(check){
            List<Product> confirmed=new ArrayList<>();

            String[] products = request.getParameterValues("products");
            List<String> productList = Arrays.asList(products);

            productList.forEach(e->confirmed.add(productService.getProductByName(e)));

            HttpSession session = request.getSession();
            session.setAttribute("cartProducts",new CartProducts(confirmed));
            session.setMaxInactiveInterval(60);
            response.sendRedirect(request.getContextPath()+"/cart");


        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
