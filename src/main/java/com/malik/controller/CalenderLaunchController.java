package com.malik.controller;

import com.malik.entity.Event;
import com.malik.entity.Task;
import com.malik.entity.User;
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
        urlPatterns = {"/calanderController"}
)

public class CalenderLaunchController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        //Request from calender jsp from list all event call
        //Request from calender jsp from add event call
        if(action == null) {
            EventDao eventDao = new EventDao();
            HttpSession httpSession = request.getSession();
            List<Task> userTasks = eventDao.getAllTasks(Integer.parseInt(httpSession.getAttribute("id").toString()));
            request.setAttribute("tasks", userTasks);
            request.getRequestDispatcher("eventList.jsp")
                    .forward(request, response);
        } else if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("add.jsp")
                    .forward(request, response);
        } else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            GenericDao genericDao = new GenericDao(Task.class);
            Task asignedTask = (Task) genericDao.getById(id);
            request.setAttribute("editTask", asignedTask);
            request.getRequestDispatcher("edit.jsp")
                    .forward(request, response);
        }
    }
}
