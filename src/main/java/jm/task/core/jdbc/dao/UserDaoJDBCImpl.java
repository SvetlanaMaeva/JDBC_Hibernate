//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Connection connection = Util.getMySQLConnection()) {
//            connection.prepareStatement("CREATE TABLE users (\n" +
//                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                    "  `name` VARCHAR(45) NULL,\n" +
//                    "  `last_name` VARCHAR(45) NULL,\n" +
//                    "  `age` INT(3) NULL,\n" +
//                    "  PRIMARY KEY (`id`))\n" +
//                    "ENGINE = InnoDB\n" +
//                    "DEFAULT CHARACTER SET = utf8;").execute();
//            System.out.println("Таблица создана.");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void dropUsersTable() {
//
//        try (Connection connection = Util.getMySQLConnection();
//             PreparedStatement statement = connection.prepareStatement("DROP TABLE IF EXISTS users;")) {
//            statement.execute();
//            System.out.println("Таблица успешно удалена!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//
//        try (Connection connection = Util.getMySQLConnection();
//             PreparedStatement statement = connection.prepareStatement("INSERT INTO users" +
//                     "(name, last_name, age) VALUES (?, ?, ?);")) {
//
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//            statement.executeUpdate();
//            System.out.printf("User по имени %s %s возрастом %d лет добавлен в базу данных.\n", name, lastName, age);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        try (Connection connection = Util.getMySQLConnection();
//             PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?;")) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//
//        List<User> userList = new ArrayList<>();
//
//        try (Connection connection = Util.getMySQLConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT id, name, last_name, age FROM users;");
//
//
//            while (resultSet.next()) {
//                User user = new User();
//
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("last_name"));
//                user.setAge(resultSet.getByte("age"));
//                userList.add(user);
//            }
//            return userList;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void cleanUsersTable() {
//        try (Connection connection = Util.getMySQLConnection();
//             PreparedStatement statement = connection.prepareStatement("DELETE FROM users;")) {
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
