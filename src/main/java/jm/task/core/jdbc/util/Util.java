package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Util instance;
    private static final String URL = "jdbc:mysql://localhost:3306/my_db2";
    private static final String USERNAME = "bestuser";
    private static final String PASSWORD = "bestuser";


    private static Connection connection;


    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }


    //SessionFactory создаем один раз потом ее можно переиспользовать
    public static SessionFactory getSessionFactory(){

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).
                buildSessionFactory();

        return sessionFactory;
    }
}
