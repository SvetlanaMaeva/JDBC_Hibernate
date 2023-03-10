package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {

        UserService user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Нил", "Гейман", (byte) 62);
        user.saveUser("Лю", "Цысинь", (byte) 59);
        user.saveUser("Виктор", "Пелевин", (byte) 60);
        user.saveUser("Эрнест", "Хемингуэй", (byte) 62);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
