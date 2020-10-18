package repository;

import models.Product;
import interfaces.ProductRepository;
import interfaces.Repository;
import models.User;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final Repository dbrepo = new PostgresRepository();

    @Override
    public List<Product> getAllProducts() {
        return query("SELECT * FROM products");
    }

    @Override
    public Product getProductbyID(int id) {
        return queryOne("SELECT * FROM products WHERE id=" + id + " LIMIT 1");
    }

    @Override
    public Product getProductByName(String name) {
        try {
            String sql = "SELECT * FROM products WHERE name=? LIMIT 1";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(
                        (long) rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getString("size"),
                        rs.getString("image_url"),
                        rs.getString("category"));
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void add(Product entity) {

    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void remove(Product entity) {

    }

    @Override//String name, String description, long price, String size, String image_url, String category
    public List<Product> query(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<Product> products = new LinkedList<>();
            while (rs.next()) {
                Product product = new Product(
                        (long) rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getString("size"),
                        rs.getString("image_url"),
                        rs.getString("category")
                );
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getSQLState());
        }
    }

    @Override
    public Product queryOne(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new Product(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getString("size"),
                        rs.getString("image_url"),
                        rs.getString("category"));
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }
}

