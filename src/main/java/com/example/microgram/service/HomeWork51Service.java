//package com.example.microgram.service;
//
//import com.example.microgram.entity.User;
//import com.example.microgram.homework51.DataBaseConnect;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class HomeWork51Service {
//
//     DataBaseConnect dbService;
//
////    private int executeUpdate(String query) throws SQLException {
////        Statement statement = dbService.getConnection().createStatement();
////        return statement.executeUpdate(query);
////    }
//
//
//    public User findUserByProfile(String profile) {
//        try {
//            String SQL = "select * from microgram " + "where profile =?";
//            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
//            statement.setString(1, profile);
//
//            if (statement.execute()) {
//                ResultSet rs = statement.getResultSet();
//                rs.next();
//
//                User user = new User();
//
//                user.setName(rs.getString("name"));
//                user.setProfile(rs.getString("profile"));
//                user.setEmail(rs.getString("email"));
//
//                return user;
//            } else {
//                throw new SQLException();
//            }
//        }catch (SQLException e) {
//            return null;
//        }
//    }
//
//    public void shouldResultSet() {
//        try {
//
//            Statement statement = dbService.getConnection().createStatement(
//                    ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE
//            );
//
////            ResultSet resultSet = statement.executeQuery("select * from customers");
////            resultSet.moveToInsertRow();
////            resultSet.updateLong("id", 3L);
////            resultSet.updateString("name", "John");
////            resultSet.updateInt("age", 18);
////            resultSet.insertRow();
////            resultSet.moveToCurrentRow();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
