package com.malik.controller;

import com.malik.entity.Task;
import com.malik.persistance.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/eventController"}
)

public class EventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Task.class);
        List<Task> tasks = genericDao.getAll();
        Task getUserTasks = new Task();
        int userId= 2;
        List<Task> userTasks = getUserTasks.getAllTaskForUser(userId, tasks);
        //System.out.println(userTasks.get(0).getUser().getId());
        String action = request.getParameter("action");
        if(action == null) {
                request.getRequestDispatcher("calender1.jsp").forward(request,response);
        }
    }
}
