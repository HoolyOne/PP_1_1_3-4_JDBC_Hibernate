package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();


    }

    public void dropUsersTable() {
        userDao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        System.out.println("User с именем" + name + " добавлен");

    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);

    }

    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }


    public void cleanUsersTable() {
        userDao.cleanUsersTable();

    }
}
