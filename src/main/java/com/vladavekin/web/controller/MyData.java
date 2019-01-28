package com.vladavekin.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyData {

    public String data() {
        Date dateNow = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        return dateFormat.format(dateNow);
    }
}
