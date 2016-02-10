package com.liangxunwang.unimanager.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuzwei on 2015/2/1.
 */
public class DateUtil {

    /**
     * 根据日期获得毫秒值
     * @param str
     * @return
     */
    public static long getMs(String str, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(str);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getDate(String time, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(Long.parseLong(time));
        return sdf.format(date);
    }

    /**
     * 获得当天的毫秒值开始
     * @return
     */
    public static long getStartDay(){
        DateTime time = new DateTime();
        String date = time.toString("yyyy-MM-dd HH:mm");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        time = DateTime.parse(date, format);
        long start = time.getMillis();
        return start;
    }

    public static long getEndDay(){
        DateTime time = new DateTime();
        String date = time.toString("yyyy-MM-dd HH:mm");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        time = DateTime.parse(date, format);
        long start = time.getMillis();
        return start+Constants.DAY_MILLISECOND;
    }

    /**
     *
     * @param now  当前时间
     * @param day  比当前时间差几天  正的就是当天时间之前几天   负的就是当前时间之后几天
     * @return
     */
    public static Object[] getDayInterval(long now, int day){
        long mis = now-(day*Constants.DAY_MILLISECOND);
        DateTime time = new DateTime(mis);
        String date = time.toString("yyyy-MM-dd HH:mm");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        time = DateTime.parse(date, format);
        long start = time.getMillis();
        return new Object[]{start, start+Constants.DAY_MILLISECOND, date};
    }



}
