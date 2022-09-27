package com.example.microgram.service;

import com.example.microgram.entity.Comment;
import com.example.microgram.entity.Publication;
import com.example.microgram.entity.User;
import com.example.microgram.homework51.DataBaseConnect;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Service
@RequiredArgsConstructor
public class Lesson51Service {

    final DataBaseConnect dbService;

    private int executeUpdate(String query) throws SQLException {
        Statement statement = dbService.getConnection().createStatement();
        return statement.executeUpdate(query);
    }


    private void createCustomerTable() throws SQLException {
        String createTableQuery = "CREATE TABLE customers( " +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "age INTEGER)";

        String insertQuery = "INSERT INTO customers " + "VALUES(73, 'Brain', 33)";

        executeUpdate(createTableQuery);
        executeUpdate(insertQuery);
    }

    public String shouldCreateTable() {
        try {
            createCustomerTable();
            dbService.getConnection().createStatement().execute("select * from customers");
            return "All it is OK";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String shouldSelectData(String name) {
        try {
            String query = "select * from customers " + "where name = ?";
            PreparedStatement statement = dbService.getConnection().prepareStatement(query);
            statement.setString(1, name);

            if (statement.execute()) {
                //return "OK";
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                int age = resultSet.getInt("age");//ResultSet расположен неправильно, возможно, вам нужно вызвать следующий.
                String resultName = resultSet.getString("name");

                return String.format("Age: %s", age);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    // HomeWork51
    public User findUserByProfile(String profile) {
        try {
            String SQL = "select * from microgram " + "where profile =?";
            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
            statement.setString(1, profile);

            if (statement.execute()) {
                ResultSet rs = statement.getResultSet();
                rs.next();

                User user = new User();

                user.setName(rs.getString("name"));
                user.setProfile(rs.getString("profile"));
                user.setEmail(rs.getString("email"));

                return user;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public Publication choose(String description) {
        try {
            String SQL = "select * from publication " + "where description =?";
            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
            statement.setString(1, description);

            if (statement.execute()) {
                ResultSet rs = statement.getResultSet();
                rs.next();

                Publication publication = new Publication();

                publication.setId(rs.getInt(1));
                publication.setUserId(rs.getInt("user_id"));
                publication.setDescription(rs.getString("description"));

                return publication;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User userAuto(String email, String password) {

        try {
            String SQL = "select * from microgram where email = ?";
            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
            statement.setString(1, email);

            User user = null;

            if (statement.execute()) {
                ResultSet rs = statement.executeQuery();
                rs.next();

                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String profile = rs.getString(3);
                String emailResult = rs.getString(4);
                String passwordResult = rs.getString(5);

                if (password.equals(passwordResult)) {

                    user = new User(id, name, profile, emailResult, passwordResult);
                }

                return user;
            } else {
                throw new SQLException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Publication addPublication(Publication publication) {

        try {
            String SQL = "insert into publication_m (user_id, link, description) values (?, ?, ?)";
            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
            statement.setInt(1, publication.getUserId());
            statement.setString(2, publication.getLink());
            statement.setString(3, publication.getDescription());

            statement.execute();
            //Добавлю LocalDateTime

//            User user = null;
//
//            if (statement.execute()) {
//                ResultSet rs = statement.executeQuery();
//                rs.next();
//
//                Integer id = rs.getInt(1);
//                String name = rs.getString(2);
//                String profile = rs.getString(3);
//                String emailResult = rs.getString(4);
//                String passwordResult = rs.getString(5);
//
//                if (password.equals(passwordResult)) {
//
//                    user = new User(id, name, profile, emailResult, passwordResult);
//                }
//
//                return user;
//            } else {
//                throw new SQLException();
//            }

            return publication;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    Метод для добавления комментария
     */
    public Comment getComment(Comment com) {
        try {
//            String SQL = "select user_m.name, publication_m.link from user_m join user_publication\n" +
//                    "    on user_m.user_id = user_publication.user_id join publication_m\n" +
//                    "on user_publication.publication_id = publication_m.publication_id;";
            String SQL = "integer into comment(comment) values (?)";
            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
            statement.setString(1, com.getText());

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public User findUserById(String profile) {
//        try {
//            String SQL = "select * from users " + "where profile =?";
//            PreparedStatement statement = dbService.getConnection().prepareStatement(SQL);
//            statement.setString(1, profile);
//
//            if (statement.execute()) {
//                ResultSet rs = statement.getResultSet();
//                rs.next();
//
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setProfile(rs.getString("profile"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//
//                return user;
//            } else {
//                throw new SQLException();
//            }
//        }catch (SQLException e) {
//            return null;
//
//        }
//    }

    public void shouldResultSet() {
        try {

            Statement statement = dbService.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
