//package com.example.microgram.utils;
//
//import com.example.microgram.entity.User;
//import com.example.microgram.homework51.DataBaseConnect;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserRegistration {
//
//    final DataBaseConnect dbService;
//    User user = new User();
//
//    public UserRegistration(DataBaseConnect dbService) {
//        this.dbService = dbService;
//    }
//
//    public User userRegistration(String email) {
//
//        try {
//            String SQL = "select * from microgram " + "where email =?";
//            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
//            statement.setString(1, email);
//
//            if (statement.execute()) {
//                ResultSet rs = statement.executeQuery();
//                rs.next();
//
//                user.setEmail(rs.getString(4));
//                return user;
//            } else {
//                throw new SQLException();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
