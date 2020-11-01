package kz.edu.astanait.controllers;

import com.google.gson.Gson;
import kz.edu.astanait.interfaces.OrderRepository;
import kz.edu.astanait.interfaces.UserRepository;
import kz.edu.astanait.models.User;
import kz.edu.astanait.repository.OrderRepositoryImpl;
import kz.edu.astanait.repository.UserRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("orders")
public class RestAPI {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();
    private final UserRepository userRepository=new UserRepositoryImpl();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello(){
        List<User> userList=userRepository.getAllUsers();
        Gson gson=new Gson();
        return gson.toJson(userList);

    }

    @DELETE
    @Path("/{id}/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeBook(@PathParam("id") int id, @PathParam("username") String username) {
        try {
            orderRepository.moveBackTheBook(id, username);
        } catch (ServerErrorException ex) {
            return Response.serverError().build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("The book is not given back").build();
        }
        return Response.status(Response.Status.OK).entity("The book is back").build();
    }
}
