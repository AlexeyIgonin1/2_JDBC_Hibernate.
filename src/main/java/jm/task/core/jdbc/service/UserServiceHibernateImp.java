package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceHibernateImp implements UserService{
    UserDao userDao = new UserDaoHibernateImpl();
    @Override
    public void createUsersTable() {
        userDao.createUsersTable();

    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName,age);

    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        for(User user : users){
            System.out.println(user);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();

    }
}
