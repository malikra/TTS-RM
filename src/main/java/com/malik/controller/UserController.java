package com.malik.controller;


import com.google.api.client.util.DateTime;
import com.malik.entity.Role;
import com.malik.entity.User;
import com.malik.persistance.GenericDao;
import com.malik.persistance.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A simple servlet to welcome the user.
 *
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/userController"}
)

public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String action = req.getParameter("action");
        GenericDao userDao = new GenericDao(User.class);
        GenericDao roleDao = new GenericDao(Role.class);

        //Principal userPrincipal = req.getUserPrincipal(); get userinfo from form tomcat jaas security
        String firstName = req.getParameter("firstName") != null ? req.getParameter("firstName") : null;
        String lastName = req.getParameter("lastName") != null ? req.getParameter("lastName") : null;
        String password = req.getParameter("password") != null ? req.getParameter("password") : null;
        String userName = req.getParameter("userName") != null ? req.getParameter("userName") : null;
        String dateOfBirth = req.getParameter("dateOfBirth") != null ? req.getParameter("dateOfBirth") : null;
        int id = req.getParameter("id") != null ? Integer.parseInt(req.getParameter("id")) : 0;

        //Add new User
        if (action != null && action.equalsIgnoreCase("addUser")) {
            UserBO userBO = new UserBO();
            User newUser = new User(firstName, lastName, userName, password, userBO.getLocalDate(dateOfBirth));
            Role role = new Role(newUser, "registered-user", userName);
            int userId = userDao.insert(newUser);
            roleDao.insert(role);
            if (userId != 0) {
                httpSession.setAttribute("id", userId);
                req.setAttribute("message", "User account created successfully !!!");
                req.setAttribute("userCreated", "yess");
                req.getRequestDispatcher("message.jsp")
                        .forward(req, resp);

            } else {

                req.setAttribute("message", "Incorrect User id or password !!!");
                req.getRequestDispatcher("userLogin.jsp")
                        .forward(req, resp);
            }

            //User login
        } else if (action != null && action.equalsIgnoreCase("userLogin")) {
            UserBO userBO = new UserBO();
            int userId = userBO.getUserId("userName", userName, "password", password);
            if (userId != 0) {
                httpSession.setAttribute("id", userId);
                resp.sendRedirect("calender.jsp");

            } else {

                req.setAttribute("message", "Incorrect User id or password. Type the correct user ID and password, and try again !!!");
                req.getRequestDispatcher("userLogin.jsp")
                        .forward(req, resp);
            }

            //Admin searching for the users
        } else if (action != null && action.equalsIgnoreCase("searchUser")) {

            if (lastName != null && !lastName.isEmpty()) {
                //req.setAttribute("users", userData.getAllUsersByLastName(req.getParameter("lastName")));
                req.setAttribute("users", userDao.getByPropertyLike("lastName", req.getParameter("lastName")));

            } else {
                //req.setAttribute("users", userData.getAllUsers());
                req.setAttribute("users", userDao.getAll());

            }
            req.getRequestDispatcher("userResult.jsp")
                    .forward(req, resp);

            //Delete User
        } else if (action != null && action.equalsIgnoreCase("delete")) {

            if (id != 0 && id > 0) {

                userDao.delete(userDao.getById(id));

            }
            req.setAttribute("message", "User deleted successfully !!!");
            req.getRequestDispatcher("userInfo.jsp")
                    .forward(req, resp);

            // User sign out
        } else if (action != null && action.equalsIgnoreCase("signOut")) {


            httpSession.removeAttribute("id");
            resp.sendRedirect("home.jsp");
        }

    }
}