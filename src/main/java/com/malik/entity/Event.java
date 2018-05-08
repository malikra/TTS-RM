package com.malik.entity;


import java.io.Serializable;
import java.util.Objects;

/**
 * The type Event.
 */
public class Event {
    private int id;
    private String title;
    private String start;
    private String end;

    /**
     * Instantiates a new Event.
     */
    public Event() {
    }

    /**
     * Instantiates a new Event.
     *
     * @param id    the id
     * @param title the title
     * @param start the start
     * @param end   the end
     */
    public Event(int id, String title, String start, String end) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
