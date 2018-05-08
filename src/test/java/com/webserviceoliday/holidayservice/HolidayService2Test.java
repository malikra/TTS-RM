package com.webserviceoliday.holidayservice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HolidayService2Test {

    @Test
    void getHolidayService2Soap12() {
        HolidayService2Soap holidayService = new HolidayService2().getHolidayService2Soap12();
        ArrayOfHoliday arraOfHolidays = holidayService.getHolidaysForYear(Country.UNITED_STATES, 2018);
        List<Holiday> holidays = arraOfHolidays.getHoliday();
        assertEquals("NEW-YEARS-DAY-ACTUAL", holidays.get(0).getHolidayCode());
        assertEquals("2018-01-01T00:00:00", holidays.get(0).getDate().toString());
    }
}