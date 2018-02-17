package com.malik.persistance;


import com.malik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user
     * @param user User to be deleted
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<User> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from( User.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<User> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<User> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<User> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

    /**
     * @param lastName
     * @return
     */
    public List<User> getAllUsersByLastName(String lastName) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        //from clause
        Root<User> root = query.from(User.class);
        //where clause
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        //result set
        List<User> users = session.createQuery(query).getResultList();
        logger.debug("The list of users " + users);
        session.close();

        return users;
    }


    /**
     * Run sql.
     *
     * @param sqlFile the sql file
     */
    public void runSQL(String sqlFile) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(sqlFile);
        Session session = sessionFactory.openSession();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = null;
            String [] row = null;
            User user = null;

            while((line = br.readLine()) != null) {

                Transaction transaction = session.beginTransaction();
                user = new User();
                row = line.split(",");
                user.setId(Integer.parseInt(row[0].trim()));
                user.setFirstName(row[1].trim());
                user.setLastName(row[2].trim());
                user.setPlace(row[3].trim());
                user.setEmail(row[4].trim());
                user.setUserName(row[5].trim());
                user.setPassword(row[6].trim());
                user.setDateOfBirth(LocalDate.parse(row[7].trim()));

                insert(user);
                transaction.commit();
            }

        } catch (IOException se) {
            logger.error(se);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            session.close();
        }
    }

}