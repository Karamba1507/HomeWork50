package com.example.microgram.utils;

import com.example.microgram.entity.User;
import com.example.microgram.homework51.DataBaseConnect;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateUser {

    DataBaseConnect dbService;

    public List<User> index() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = dbService.getConnection().createStatement();
            String SQL = "select * from microgram";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setProfile(resultSet.getString("profile"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void saveUser(User user) {
        try {
            PreparedStatement ps = dbService.getConnection().prepareStatement("insert into microgram values(1,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getProfile());
            ps.setString(3, user.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User show(String name) {
        User user = null;
        try {
            PreparedStatement ps = dbService.getConnection().prepareStatement("" +
                    "select * from microgram where name=?");

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            rs.next();

            user = new User();

            user.setName(rs.getString("name"));
            user.setProfile(rs.getString("profile"));
            user.setEmail(rs.getString("email"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
