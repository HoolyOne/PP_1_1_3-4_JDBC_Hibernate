package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Иван", "Иванов", (byte) 25);
        userService.saveUser("Петр", "Петров", (byte) 30);
        userService.saveUser("Александр", "Александров", (byte) 19);

        System.out.println("Получение всех пользователей");
        userService.getAllUsers();

        userService.cleanUsersTable();
        System.out.println("Таблица очищена");

        userService.dropUsersTable();
        System.out.println("Таблица удалена");
    }
}
