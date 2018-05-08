package com.malik.persistance;

import com.malik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

/**
 * The type User bo.
 */
public class UserBO {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The User dao.
     */
    GenericDao userDao = new GenericDao(User.class);

    /**
     * Gets user.
     *
     * @param propertyName1 the property name 1
     * @param value1        the value 1
     * @param propertyName2 the property name 2
     * @param value2        the value 2
     * @return the user
     */
    public int getUserId(String propertyName1, String value1, String propertyName2, String value2) {
        List<User> users = userDao.getByPropertyEqual(propertyName1, value1, propertyName2, value2);
        int userId = 0;
        if (users != null && users.size() > 0) {
            User user = new User();
            user = users.get(0);
            userId = user.getId();
        }
        return userId;
    }

    /**
     * Gets local date.
     *
     * @param date the date
     * @return the local date
     */
    public LocalDate getLocalDate(String date)  {

        String strDate = date.substring(6,10) + "-" +
                date.substring(0, 2) + "-" +
                date.substring(3, 5);
        return LocalDate.parse(strDate);
    }
}
