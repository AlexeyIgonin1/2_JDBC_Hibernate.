package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceHibernateImp;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final UserService userService1 = new UserServiceHibernateImp();

    public static void main(String[] args) {

//        userService.createUsersTable();
//        System.out.println("***************");
//        userService.saveUser("Tom", "Ivanov", (byte)34);
//        userService.saveUser("Ivan", "Matrenin", (byte)45);
//        userService.saveUser("Tom", "Hanks", (byte)66);
//        userService.saveUser("Jim", "Curry", (byte)56);
//        userService.saveUser("Jim", "Carrey", (byte)61);
//        System.out.println("***************");
//        userService.removeUserById(3);
//        System.out.println("***************");
//        userService.getAllUsers();
//        System.out.println("***************");
//        userService.cleanUsersTable();
//        System.out.println("***************");
//        userService.dropUsersTable();












        userService1.createUsersTable();
        System.out.println("***************");
//        userService1.saveUser("Tom", "Ivanov", (byte)34);
//        userService1.saveUser("Ivan", "Matrenin", (byte)45);
//        userService1.saveUser("Tom", "Hanks", (byte)66);
//        userService1.saveUser("Jim", "Curry", (byte)56);
//        userService1.saveUser("Jim", "Carrey", (byte)61);
//        System.out.println("***************");
//        userService1.removeUserById(3);
//        System.out.println("***************");
//        userService1.getAllUsers();
//        System.out.println("***************");
//        userService1.cleanUsersTable();
//        System.out.println("***************");
//        userService1.dropUsersTable();









    }
}
