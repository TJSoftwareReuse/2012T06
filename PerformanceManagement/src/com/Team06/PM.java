package com.Team06;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by r on 2015/4/23.
 */
public class PM
{
    private static class SingletonHolder
    {
        public final static Map<String, Integer> instance = new HashMap<String, Integer>();
        public static String prevDateTime = "";
    }

    public static String getDateTime()
    {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        String formattedDateTime = ldt.format(formatter);
        return formattedDateTime;
    }


    public synchronized static void sendMsg(String key, int value)
    {
        String dateTime = getDateTime();
        if (!dateTime.equals(SingletonHolder.prevDateTime))
        {
            SingletonHolder.instance.clear();
            SingletonHolder.prevDateTime = dateTime;
        }

        if(SingletonHolder.instance.containsKey(key))
            SingletonHolder.instance.put(key, value + SingletonHolder.instance.get(key));
        else {
            SingletonHolder.instance.put(key, value);
        }

        printLog(dateTime);
    }


    public static synchronized void printLog(String dateTime)
    {
        try{
            PrintWriter writer = new PrintWriter(dateTime + ".log", "UTF-8");
            writer.println("PM Report of " + dateTime);
            for (String key: (SingletonHolder.instance).keySet())
            {
                writer.println(key + " : " + SingletonHolder.instance.get(key).toString());
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}