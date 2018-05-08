package com.malik.persistance;

import com.malik.entity.Task;
import com.malik.entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Event bo.
 */
public class EventBO {

    /**
     * The Generic dao.
     */
    GenericDao genericDao = new GenericDao(Task.class);
    /**
     * The User generic dao.
     */
    GenericDao userGenericDao = new GenericDao(User.class);

    /**
     * Getevent id int.
     *
     * @param taskName  the task name
     * @param startTime the start time
     * @param endTime   the end time
     * @param userId    the user id
     * @return the int
     */
    public int addEvent(String taskName,String startTime,String endTime, int userId){
        int id = 0;
        User retrievedUser = (User)userGenericDao.getById(userId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        Task newTask = new Task(taskName, startDateTime,  endDateTime, retrievedUser);
        id = genericDao.insert(newTask);
        return id;
    }

    /**
     * Delete event.
     *
     * @param id the id
     */
    public void deleteEvent(int id){

        Task asignedTask = (Task) genericDao.getById(id);
        genericDao.delete(asignedTask);
    }

    /**
     * Edit event.
     *
     * @param taskName  the task name
     * @param startTime the start time
     * @param endTime   the end time
     * @param id        the id
     */
    public void editEvent(String taskName, String startTime, String endTime, int id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        Task updatedTask = (Task)genericDao.getById(id);
        updatedTask.setTaskName(taskName);
        updatedTask.setStartTime(startDateTime);
        updatedTask.setEndTime(endDateTime);
        genericDao.saveOrUpdate(updatedTask);
    }
}
