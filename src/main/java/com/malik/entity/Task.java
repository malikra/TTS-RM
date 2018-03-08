package com.malik.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Task.
 */
@Entity(name = "Task")
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "start_tms")
    private LocalDateTime startTime;

    @Column(name = "end_tms")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "tasks_user_id_fk"))
    private User user;

    /**
     * Instantiates a new Task.
     */
    public Task() {
    }


    /**
     * Instantiates a new Task.
     *
     * @param taskName  the task name
     * @param startTime the start time
     * @param endTime   the end time
     * @param user      the user
     */
    public Task(String taskName, LocalDateTime startTime, LocalDateTime endTime, User user) {
        this.taskName = taskName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets task name.
     *
     * @return the task name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Sets task name.
     *
     * @param taskName the task name
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(taskName, task.taskName) &&
                Objects.equals(startTime, task.startTime) &&
                Objects.equals(endTime, task.endTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, taskName, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", user=" + user +
                '}';
    }
}
