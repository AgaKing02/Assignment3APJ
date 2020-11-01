package kz.edu.astanait.controllers.control;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kz.edu.astanait.interfaces.BookRepository;
import kz.edu.astanait.interfaces.OrderRepository;
import kz.edu.astanait.repository.BookRepositoryImpl;
import kz.edu.astanait.repository.OrderRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderRemove")
public class OrderRemove extends HttpServlet {
    private final OrderRepository orderRepository=new OrderRepositoryImpl();
    private final BookRepository bookRepository=new BookRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();

        int bookid= Integer.parseInt(request.getParameter("reqValue"));
        orderRepository.removeOrderSByBookIsbn(bookid);
        bookRepository.remove(bookRepository.getBookByIsbn(bookid));
        myObj.addProperty("success",true);
        out.println(myObj.toString());
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
