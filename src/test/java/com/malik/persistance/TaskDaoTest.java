package com.malik.persistance;

import com.malik.entity.Task;
import com.malik.entity.User;
import com.malik.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskDaoTest {

    UserDao userDao;
    GenericDao genericDao;
    GenericDao userGenericDao;
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleanDatabase.sql");
        userDao = new UserDao();
        genericDao = new GenericDao(Task.class);
        userGenericDao = new GenericDao(User.class);
//        List<User> users = userDao.getAll();
//        for (User user : users) {
//            userDao.delete(user);
//        }
//         userDao.runSQL("cleandb.sql");
    }

    @Test
    void getById() {
        //User retrievedUser = userDao.getById(1);
        Task asignedTask = (Task)genericDao.getById(1);
        assertEquals("maths", asignedTask.getTaskName());
    }

    @Test
    void saveOrUpdate() {
        Task asignedTask = (Task) genericDao.getById(3);
        asignedTask.setTaskName("eng");
        genericDao.saveOrUpdate(asignedTask);
        Task updatedTask = (Task)genericDao.getById(3);
        assertEquals("eng", updatedTask.getTaskName());
    }

    @Test
    void insert() {
        User retrievedUser = (User)userGenericDao.getById(4);
        Task newTask = new Task("Arabic", LocalDateTime.now().minusHours(1),  LocalDateTime.now(), retrievedUser);
        int id = genericDao.insert(newTask);
        assertNotEquals(0,id);
        Task insertedTask = (Task)genericDao.getById(id);
        assertEquals("Arabic", insertedTask.getTaskName());
    }

    @Test
    void delete() {
        genericDao.delete((Task)genericDao.getById(3));
        assertNull((Task)genericDao.getById(3));
    }

    @Test
    void deleteAll() {
        userDao = new UserDao();
        List<Task> tasks = genericDao.getAll();
        for (Task task : tasks) {
            genericDao.delete(task);
        }
        assertEquals(0,genericDao.getAll().size());
    }

    @Test
    void getAll() {
       List<User> users = genericDao.getAll();
       assertNotNull(users);
       assertEquals(4, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<Task> tasks = genericDao.getByPropertyLike("taskName", "ma");
        assertNotEquals(1, tasks.size());
        assertEquals(1, tasks.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<Task> tasks = genericDao.getByPropertyLike("taskName", "en");
        assertEquals(1, tasks.size());
    }

    @Test
    void getAllUsersByLastName() {
        List<Task> tasks = genericDao.getAll();
        assertEquals(4, tasks.size());
    }
}