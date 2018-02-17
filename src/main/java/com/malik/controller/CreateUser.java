package com.malik.controller;


import com.malik.persistance.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/createUser"}
)

public class CreateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserData userData = new UserData();
        UserDao userDao = new UserDao();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String gender = req.getParameter("gender");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String userName = req.getParameter("gender");
        String emailId = req.getParameter("emailId");
        String password = req.getParameter("password");
        String id = req.getParameter("id");

        if(lastName != null && !lastName.isEmpty()) {
            //req.setAttribute("users", userData.getAllUsersByLastName(req.getParameter("lastName")));
            req.setAttribute("users", userDao.getByPropertyLike("lastName", req.getParameter("lastName")));

        } else {
            //req.setAttribute("users", userData.getAllUsers());
            req.setAttribute("users", userDao.getAll());

        }

       RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}