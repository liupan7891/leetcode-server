package cn.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by l on 2016/6/21.
 */
public class DateUtils {

    public static final String[] pattens = new String[]{
            "yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd",
            "yyyy-M-dd"
    };

    public static Date parseDate(String dateStr, DateFormat df)  {
        try {
            if (dateStr == null || dateStr.trim().length() == 0) {
                return null;
            }
            return df.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDate(String dateStr, String format)  {
        try {
            if (dateStr == null || dateStr.trim().length() == 0) {
                return null;
            }
            DateFormat df = new SimpleDateFormat(format);
            return df.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDate(String dateString) {
        for (int i=0; i< pattens.length; i++ ) {
            DateFormat df = new SimpleDateFormat(pattens[i]);
            Date date = parseDate(dateString, df);
            if (date != null)  {
                return date;
            }
        }
        return null;
    }

    /**
     * 日期转换成字符串
     * @param date
     * @param patten
     * @return
     */
    public static String format(Date date, String patten){
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        return sdf.format(date);
    }

    /*public static void main(String[] args){

    }*/
}
