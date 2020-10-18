package repository;

import models.User;
import models.UserLoginData;
import interfaces.Repository;
import interfaces.UserRepository;

import javax.ws.rs.BadRequestException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final Repository dbrepo = new PostgresRepository();

    @Override
    public void add(User entity) {
        try {
            String sql = "INSERT INTO users(name, surname, username, password, birthday, role) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getSurname());
            stmt.setString(3, entity.getUsername());
            stmt.setString(4, entity.getPassword());
            stmt.setDate(5, (Date) entity.getBirthday());
            stmt.setString(6, entity.getRole());

            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void update(User entity) { // Spring
        String sql = "UPDATE users SET ";

        if (entity.getName() != null)
            sql += "name=?,";
        if (entity.getSurname() != null)
            sql += "surname=?,";
        if (entity.getPassword() != null)
            sql += "password=?,";
        if (entity.getBirthday() != null)
            sql += "birthday=?,";

        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE username=?";

        try {
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            int i = 1;
            if (entity.getName() != null)
                stmt.setString(i++, entity.getName());
            if (entity.getSurname() != null)
                stmt.setString(i++, entity.getSurname());
            if (entity.getPassword() != null)
                stmt.setString(i++, entity.getPassword());
            if (entity.getBirthday() != null)
                stmt.setDate(i++, (Date) entity.getBirthday());
            stmt.setString(i++, entity.getUsername());

            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public List<User> query(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<User> users = new LinkedList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        //rs.getString("password"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getSQLState());
        }
    }

    @Override
    public User queryOne(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    public User getUserByID(long id) {
        String sql = "SELECT * FROM users WHERE id = " + id + " LIMIT 1";
        return queryOne(sql);
    }

    public User findUserByLogin(UserLoginData data) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, data.getUsername());
            stmt.setString(2, data.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }
}
