package kz.edu.astanait.repository;

import kz.edu.astanait.interfaces.OrderRepository;
import kz.edu.astanait.interfaces.Repository;
import kz.edu.astanait.models.Order;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void moveBackTheBook(int id, String username) {
        try {
            String sql = "DELETE from orders WHERE product_id=? and username=?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, username);
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void removeOrderSByBookIsbn(int isbn) {
        try {
            String sql = "DELETE from orders WHERE product_id=?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setInt(1, isbn);
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void add(Order entity) {
        try {
            String sql = "INSERT INTO orders(username,product_id) VALUES(?, ?);";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getUsername());
            stmt.setInt(2, entity.getProduct_id());
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
                        rs.getInt("product_id")
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
