package util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 25.09.2016.
 */
public class StringUtils {
    public static int stringTineToSeconds(String timeInString) {
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        Pattern pattern = Pattern.compile("([1-9]*)( )(days)(.*)");
        Matcher matcher = pattern.matcher(timeInString);
        if (matcher.matches()) {
            days = Integer.parseInt(matcher.group(1));
        }

        Pattern pattern1 = Pattern.compile("([1-9]*)( )(hours)(.*)");
        Matcher matcher1 = pattern1.matcher(timeInString);
        if (matcher1.find()) {
            hours = Integer.parseInt(matcher1.group(1));
        }

        pattern1 = Pattern.compile("([1-9]*)( )(minutes)(.*)");
        matcher1 = pattern1.matcher(timeInString);
        if (matcher1.find()) {
            minutes = Integer.parseInt(matcher1.group(1));
        }

        pattern1 = Pattern.compile("([1-9]*)( )(seconds)(.*).");
        matcher1 = pattern1.matcher(timeInString);
        if (matcher1.find()) {
            seconds = (int) (Double.parseDouble(matcher1.group(1)));
        }
        seconds = seconds + minutes * 60 + hours * 60 * 60 + days * 24 * 60 * 60;
        return seconds;
    }

    public static String secondsToDate(int time) {
        time= time;
        int day = (int) TimeUnit.SECONDS.toDays(time);
        long hours = TimeUnit.SECONDS.toHours(time);
        hours = hours-day*24;
        long minute = TimeUnit.SECONDS.toMinutes(time) ;
        minute = minute - hours*60 - day*24*60;
        int second = (int) (time - minute*60 - hours*60*60 - day*24*60*60);
        return day+" days "+hours+" hours " + minute +" minutes " +second + " seconds";
    }
}
