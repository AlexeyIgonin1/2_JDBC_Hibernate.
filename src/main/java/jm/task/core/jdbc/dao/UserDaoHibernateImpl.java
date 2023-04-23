package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    SessionFactory sessionFactory = Util.getSessionFactory();


    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)")
                    .executeUpdate();
            transaction.commit();
            System.out.println("Create table");
        }
        catch(HibernateException e) {
            e.printStackTrace();
        }
        }

    @Override
    public void dropUsersTable() {

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
            System.out.println("DROP TABLE");
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
            System.out.println("Delete person " + id);
        } catch(HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            users = session.createQuery("From User").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            transaction.commit();
            System.out.println("Delete!");
        } catch(HibernateException e){
            e.printStackTrace();
        }
    }
}
