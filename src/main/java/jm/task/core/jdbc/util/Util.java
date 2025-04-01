package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "3325";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Подключение успешно");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Ошибка подключения к БД", e);
        }
        return con;
    }
}
