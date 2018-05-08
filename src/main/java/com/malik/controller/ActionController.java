package com.malik.controller;

import com.malik.entity.Event;
import com.malik.entity.Task;
import com.malik.entity.User;
import com.malik.persistance.EventBO;
import com.malik.persistance.EventDao;
import com.malik.persistance.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(
        urlPatterns = {"/actionController"}
)
public class ActionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        String action = request.getParameter("action");
        //Request from Add jsp page
        if (action.equalsIgnoreCase("add")) {
            int userId = Integer.parseInt(httpSession.getAttribute("id").toString());
            String taskName = request.getParameter("taskName");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            EventBO eventBO = new EventBO();
            //To get event id 1 if event saved successfully
            int id = eventBO.addEvent(taskName,startTime,endTime,userId);
            if (id > 0) {
                request.setAttribute("message", "Event added successfully !!!");
            } else {
                request.setAttribute("message", "Event not added successfully !!!");
            }
            request.getRequestDispatcher("message.jsp")
                    .forward(request, response);
            //Request from eventList jsp page for delete action
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            EventBO eventBO = new EventBO();
            //Delete event
            eventBO.deleteEvent(id);
            request.setAttribute("message", "Event deleted successfully !!!");
            request.getRequestDispatcher("message.jsp")
                    .forward(request, response);
            //Request from Edit jsp page
        } else if (action.equalsIgnoreCase("edit")) {
            String taskName = request.getParameter("taskName");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            int id = Integer.parseInt(request.getParameter("id"));
            EventBO eventBO = new EventBO();
            //Edit event
            eventBO.editEvent(taskName,startTime,endTime,id);
            request.setAttribute("message", "Event modified successfully !!!");
            request.getRequestDispatcher("message.jsp")
                    .forward(request, response);
        }
    }
}
