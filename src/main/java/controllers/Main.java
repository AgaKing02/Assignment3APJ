package controllers;//import services.implementations.UserServiceImpl;
//import services.UserService;

import models.Product;
import services.ProductService;
import services.UserService;
import services.implementations.ProductServiceImpl;
import services.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "controllers.Main")
public class Main extends HttpServlet {
    public static int iHitCounter;
    private final ProductService productService =new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void init() throws ServletException
    {
        iHitCounter = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products=productService.getAllProducts();
        if(request.getParameter("sort_by")!=null)
        Collections.sort(products);
        request.setAttribute("products",products);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
