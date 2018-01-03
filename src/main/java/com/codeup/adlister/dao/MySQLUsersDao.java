package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLUsersDao implements Users{

    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    @Override
    public Long insert(User user) {
        try {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getEmail());
            PreparedStatement stmt = createUserInsertQuery(user);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating user.", e);
        }
    }

    private PreparedStatement createUserInsertQuery(User user) throws SQLException{
        String sql = "INSERT INTO users (username, email, password ) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());
        return stmt;
    }
}
