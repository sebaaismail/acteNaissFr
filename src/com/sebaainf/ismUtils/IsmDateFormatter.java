package com.sebaainf.ismUtils;

import javax.swing.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by admin on 04/02/2015.
 */
public class IsmDateFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern;
    private SimpleDateFormat dateFormatter;

    public IsmDateFormatter() {

        this.datePattern = "dd/MM/yyyy";
        dateFormatter = new SimpleDateFormat(datePattern);
    }

    public IsmDateFormatter(String datePattern) {

        this.datePattern = datePattern;
        dateFormatter = new SimpleDateFormat(datePattern);
    }


    @Override
    public Object stringToValue(String text) throws ParseException {

        text = text.replace("-", "/");
        text = text.replace(".", "/");
        text = text.replace(" ", "/");

         Date date = new Date(dateFormatter.parse(text).getTime());
       Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
        //return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {

        if (value != null) {

            // those two lines are the right way use them but before that
            // i have to handle all date of my app : dateMar dateDiv ...
           //Calendar cal = (Calendar) value;
           //return dateFormatter.format(cal.getTime());
//*
            Date date;
            Calendar cal = Calendar.getInstance();

            if (value.getClass() == GregorianCalendar.class) {
                GregorianCalendar gc = (GregorianCalendar) value;
                date = gc.getTime();
                System.out.println("hna GregorianCalendar .." + dateFormatter.format(date));

            } else if (value.getClass().getCanonicalName().equals("java.util.Date")) {
//                Calendar cal2 = (Calendar) value;
                System.out.println("hna .." + dateFormatter.format(value));
                return dateFormatter.format(value);
            }
                    else {
                cal.setTimeInMillis(((Timestamp)value).getTime() );
                date = cal.getTime();
                System.out.println(value.getClass().getCanonicalName());
            }

            return dateFormatter.format(date);
            //*/

        }

        return "";
    }
}
