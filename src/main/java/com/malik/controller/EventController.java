package com.malik.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.malik.entity.Event;
import com.malik.entity.Task;
import com.malik.persistance.EventDao;
import com.malik.persistance.GenericDao;
import com.webserviceoliday.holidayservice.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Event controller.
 */
@WebServlet(
        urlPatterns = {"/eventController"}
)

public class EventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDao eventDao = new EventDao();
        Gson gson = new Gson();
        HttpSession httpSession = request.getSession();
        List<Event> events = eventDao.getEventListByUserId(Integer.parseInt(httpSession.getAttribute("id").toString()));
        //Adding Holidays
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int eventId = events.get(events.size() - 1).getId();
        HolidayService2Soap holidayService = new HolidayService2().getHolidayService2Soap12();
        ArrayOfHoliday arraOfHolidays = holidayService.getHolidaysForYear(Country.UNITED_STATES, year);
        List<Holiday> holidays = arraOfHolidays.getHoliday();
        for(Holiday holiday : holidays) {
            eventId += 1;
            String startDate = holiday.getDate().toString().substring(0,10)+" "+"00:00:01";
            String endDate = holiday.getDate().toString().substring(0,10)+" "+"23:59:59";
            Event event = new Event();
            event.setId(eventId);
            event.setTitle(holiday.getHolidayCode());
            event.setStart(startDate);
            event.setEnd(endDate);
            events.add(event);
        }
        String arrayToJson = gson.toJson(events);
        PrintWriter writer = response.getWriter();
        writer.print(arrayToJson);
        writer.flush();
        writer.close();

    }
}
