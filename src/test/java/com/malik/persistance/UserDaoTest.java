package com.malik.persistance;

import com.malik.entity.User;
import com.malik.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao genericDao;
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleanDatabase.sql");
        genericDao = new GenericDao(User.class);
//        List<User> users = userDao.getAll();
//        for (User user : users) {
//            userDao.delete(user);
//        }
//         userDao.runSQL("cleandb.sql");
    }

    @Test
    void getById() {
        //User retrievedUser = userDao.getById(1);
        User retrievedUser = (User)genericDao.getById(1);
        assertEquals("Joe", retrievedUser.getFirstName());
        assertEquals("Coyne", retrievedUser.getLastName());
        assertEquals("jcoyne", retrievedUser.getUserName());
    }

    @Test
    void saveOrUpdate() {
        User retrievedUser = (User)genericDao.getById(3);
        retrievedUser.setFirstName("Barey");
        retrievedUser.setLastName("Cuur");
        genericDao.saveOrUpdate(retrievedUser);
        User updatedUser = (User)genericDao.getById(3);
        assertEquals("Barey", updatedUser.getFirstName());
        assertEquals("Cuur", updatedUser.getLastName());
    }

    @Test
    void insert() {

        User newUser = new User("Fred", "Flintstone", "fflintstone","supersecret7", LocalDate.parse("1968-01-01"));
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("Fred", insertedUser.getFirstName());
    }

    @Test
    void delete() {
        genericDao.delete((User)genericDao.getById(3));
        assertNull((User)genericDao.getById(3));
    }

    @Test
    void deleteAll() {
        List<User> users = genericDao.getAll();
        for (User user : users) {
            genericDao.delete(user);
        }
        assertEquals(0,genericDao.getAll().size());
    }

    @Test
    void getAll() {
       List<User> users = genericDao.getAll();
       assertNotNull(users);
       assertEquals(6, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = genericDao.getByPropertyLike("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<User> users = genericDao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }

    @Test
    void getAllUsersByLastName() {
        List<User> users = genericDao.getAll();
        assertEquals(6, users.size());
    }
}