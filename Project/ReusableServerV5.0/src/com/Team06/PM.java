package com.Team06;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        public static String logPath = "." + File.separator; // default to current directory. i.e. ".\" on Windows or "./" on Linux
        public static long prevNumericalTime = 0;
        public static long printInterval = 60 * 1000;
    }

    public static String getDateTime()
    {
    	Date ldt = new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
        String formattedDateTime = formatter.format(ldt);
        return formattedDateTime;
    }
    
    public static String getDateTime2(Date ldt)
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = formatter.format(ldt);
        return formattedDateTime;
    }

    public static void setPrintInterval(long seconds)
    {
    	SingletonHolder.printInterval = seconds * 1000;
    }
    
    public static void setLogFilePath(String newPath)
    {
    	SingletonHolder.logPath = newPath;
    }
    
    public synchronized static void sendMsg2(String key, int value)
    {
    	if (new Date().getTime() - SingletonHolder.prevNumericalTime >= SingletonHolder.printInterval)
    	{
    		SingletonHolder.instance.clear();
            SingletonHolder.prevDateTime = getDateTime2(new Date()) + " - " + getDateTime2(new Date(new Date().getTime() + SingletonHolder.printInterval));
            SingletonHolder.prevNumericalTime = new Date().getTime();
    	}
    	
    	if(SingletonHolder.instance.containsKey(key))
            SingletonHolder.instance.put(key, value + SingletonHolder.instance.get(key));
        else
            SingletonHolder.instance.put(key, value);
    	
    	printLog(SingletonHolder.prevDateTime);
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


    public static synchronized void printLog(String filename)
    {
        try{
            PrintWriter writer = new PrintWriter(SingletonHolder.logPath + filename + ".log", "UTF-8");
            writer.println("PM Report of " + filename);
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