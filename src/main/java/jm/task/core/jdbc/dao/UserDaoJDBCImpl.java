package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    Connection con = getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        try (Statement stmt = con.createStatement()){
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "lastName VARCHAR(255), " +
                    "age TINYINT)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {

        try (Statement stmt = con.createStatement()){
            stmt.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        try (PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, lastName, age) VALUES (?,?,?)")){
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age"));
                user.setId(rs.getLong("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement stmt = con.createStatement()) {
            stmt.execute("TRUNCATE TABLE users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
