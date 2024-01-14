package edu.ics211.spring2024;

public class Dates{

    private static final long SECONDS_IN_DAY = 24 * 60 * 60;
    private static final long SECONDS_IN_HOUR = 60 * 60;
    private static final long SECONDS_IN_MINUTE = 60;

    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29};

    public static void main(String[] args){
        System.out.println(computeDateTime(31536000, true));
    }

    public static String computeDateTime(long seconds, boolean isLeapYear){

        String result = "";

        long day = seconds / SECONDS_IN_DAY + 1;
        seconds = seconds % SECONDS_IN_DAY;

        long hour = seconds / SECONDS_IN_HOUR;
        seconds = seconds % SECONDS_IN_HOUR;

        long minute = seconds / SECONDS_IN_MINUTE;
        seconds = seconds % SECONDS_IN_MINUTE;

        int month = 0;
        int currentMonth = 0;

        while(month < 11 && day >= daysInMonths[month + 1]){
            if(isLeapYear){
                day = day - daysInMonths[12];
            } else{
                day = day - daysInMonths[currentMonth];
            }
            currentMonth = currentMonth + 1;
        }

        result = MONTHS[month] + " " + day + " " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", seconds);

        return result;
    }

    public static long dateToSeconds(int month, int day, int hour, int minute, int secs){
        long seconds = 0;



        return seconds;
    }

}