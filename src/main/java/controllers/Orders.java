package controllers;

import interfaces.OrderRepository;
import models.Order;
import repository.OrderRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Orders")
public class Orders extends HttpServlet {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean userExistence = false;
        String username = null;
        Cookie[] cookies = request.getCookies();
        //Displaying User name value from cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                userExistence = true;
                username = cookie.getValue();
                break;
            }
        }
        if (!userExistence) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            HttpSession session = request.getSession();
            Map<String, Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("visit", Main.iHitCounter);
            stringObjectMap.put("sessioncreation", new Date(session.getCreationTime()));
            stringObjectMap.put("lastAccess", new Date(session.getLastAccessedTime()));
            request.setAttribute("hash", stringObjectMap);

            List<Order> orders = orderRepository.getMyOrders(username);
            request.setAttribute("my", orders);
            request.getRequestDispatcher("/order.jsp").forward(request, response);
        }

    }
}
