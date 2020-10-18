package repository;

import interfaces.OrderRepository;
import interfaces.Repository;
import models.Order;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final Repository dbrepo = new PostgresRepository();

    @Override
    public List<Order> getMyOrders(String username) {
        String sql = "SELECT * FROM orders WHERE username='" + username + "' ;";
        return query(sql);
    }

    @Override
    public void add(Order entity) {
        try {
            String sql = "INSERT INTO orders(username,product_id) " +
                    "VALUES(?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getUsername());
            stmt.setInt(2, entity.getId());
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void remove(Order entity) {

    }

    @Override
    public List<Order> query(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Order> orders = new LinkedList<>();
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getLong("product_id")
                );
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getSQLState());
        }
    }

    @Override
    public Order queryOne(String sql) {
        return null;
    }
}
