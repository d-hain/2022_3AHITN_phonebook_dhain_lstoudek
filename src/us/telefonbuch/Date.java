/**
 * Date (not the romantical one)
 * @author David Hain
 */

package us.telefonbuch;

import java.sql.Struct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date{
    private int day;
    private int mon;
    private int year;

    public int getDay(){
        return day;
    }

    public int getMon(){
        return mon;
    }

    public int getYear(){
        return year;
    }

    public Date(int day, int mon, int year){
        this.day = day;
        this.mon = mon;
        this.year = year;
    }

    public Date(String date){

    }

    public static void main(String[] args) throws IllegalDateException{
        Date d = new Date(1, 12, 2022);
        System.out.println(Date.isValid(d));
    }

    public boolean isLeapYear(){
        return (double)(this.year % 4) == 0;
    }

    /**
     * max Date: 2099-12-31
     * @param d Date to check
     * @return true ... Date is valid
     *         false ... Date is not valid
     * @throws IllegalDateException when the date is not valid
     */
    public static boolean isValid(Date d) throws IllegalDateException{
        Pattern pattern = Pattern.compile("(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])");
        String dateS = d.getYear() + "-" + ((d.getMon() < 10) ? ("0" + d.getMon()) : d.getMon()) + "-" + ((d.getDay() < 10) ? ("0" + d.getDay()) : d.getDay());
        Matcher matcher = pattern.matcher(dateS);

        if(matcher.matches()){
            System.out.println("yey");
        }// TODO: pattern geht und matches auch

        if(d.getMon() == 2 && d.getDay() < 30){
            if(d.isLeapYear() && d.getDay() > 28){
                throw new IllegalDateException(0);
            }

        }

        return false;
    }
}
