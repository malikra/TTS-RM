package com.malik.persistance;

import com.malik.entity.Event;
import com.malik.entity.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Event dao.
 */
public class EventDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Event dao.
     */
    public EventDao() {

    }

    /**
     * Gets event list by user id.
     *
     * @param userId the user id
     * @return the event list by user id
     */
    public List<Event> getEventListByUserId(int userId) {
        List<Task> userTasks = this.getAllTasks(userId);
        List<Event> events = new ArrayList<Event>();
        int eventId = 0;
        for (Task task : userTasks) {
            //eventId += 1;
            Event event = new Event(task.getId(), task.getTaskName(), task.getStartTime().toString(), task.getEndTime().toString());
            events.add(event);
        }
        return events;
    }

    /**
     * Gets all tasks.
     *
     * @param userId the user id
     * @return the all tasks
     */
    public List<Task> getAllTasks(int userId) {
        GenericDao genericDao = new GenericDao(Task.class);
        List<Task> tasks = genericDao.getAll();
        Task getUserTasks = new Task();
        List<Task> userTasks = getUserTasks.getAllTaskForUser(userId, tasks);

        return userTasks;
    }
}
