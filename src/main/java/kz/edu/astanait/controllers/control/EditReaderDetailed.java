package kz.edu.astanait.controllers.control;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kz.edu.astanait.interfaces.UserRepository;
import kz.edu.astanait.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditReaderDetailed")
public class EditReaderDetailed extends HttpServlet {
    private final UserRepository userRepository=new UserRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        int userid= Integer.parseInt(request.getParameter("reqValue"));
        userRepository.remove(userRepository.getUserByID(userid));
        myObj.addProperty("success",true);
        out.println(myObj.toString());
        out.close();
    }
}
