/**
 * Date (not the romantical one)
 * Saves Date with day, month and year
 * Can check if it is a leap year
 * Can check if it has a valid format
 * Has a toString() method
 * @author David Hain
 */

package us.telefonbuch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date{
    private final int day;
    private final int mon;
    private final int year;

    public int getDay(){
        return day;
    }

    public int getMon(){
        return mon;
    }

    public int getYear(){
        return year;
    }

    /**
     * sets Date (day, month, year)
     * @param day Integer
     * @param mon Integer
     * @param year Integer
     */
    public Date(int day, int mon, int year){
        this.day = day;
        this.mon = mon;
        this.year = year;
    }

    /**
     * Sets date with a input String
     * @param date String (input)
     *             Format: yyyy-mm-dd
     */
    public Date(String date){
        String[] splitted = date.split("-");
        this.year = Integer.parseInt(splitted[0]);
        this.mon = Integer.parseInt(splitted[1]);
        this.day = Integer.parseInt(splitted[2]);
    }

    /**
     * Checks if Date is a leap year
     * @return true ... year is a leap year
     *         false ... year is not a leap year
     */
    public boolean isLeapYear(){
        return (this.year % 4) == 0;
    }

    /**
     * max Date: 2099-12-31
     *
     * @param d Date to check
     * @return true ... Date is valid
     *         false ... Date is not valid
     * @throws IllegalDateException when the date is not valid
     */
    public static boolean isValid(Date d) throws IllegalDateException{
        Pattern pattern = Pattern.compile("(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])");
        String dateS = d.getYear() + "-" + ((d.getMon() < 10) ? ("0" + d.getMon()): d.getMon()) + "-" + ((d.getDay() < 10) ? ("0" + d.getDay()): d.getDay());
        Matcher matcher = pattern.matcher(dateS);
        boolean isValid = false;

        if(matcher.matches()){
            switch(d.getMon()){
                case 1, 3, 5, 7, 8, 10, 12: // 31 Days
                    if(d.getDay() > 31){
                        throw new IllegalDateException(IllegalDateException.DAY_ILLEGAL);
                    } else{
                        isValid = true;
                    }
                    break;
                case 4, 6, 9, 11: // 30 Days
                    if(d.getDay() > 30){
                        throw new IllegalDateException(IllegalDateException.DAY_ILLEGAL);
                    } else{
                        isValid = true;
                    }
                    break;
                case 2: // 28 or 29 Days
                    if(d.getDay() < 30){
                        if(d.isLeapYear() && d.getDay() > 29){
                            throw new IllegalDateException(IllegalDateException.DAY_ILLEGAL);
                        } else if(!d.isLeapYear() && d.getDay() > 28){
                            throw new IllegalDateException(IllegalDateException.DAY_ILLEGAL);
                        } else{
                            isValid = true;
                        }
                    } else{
                        throw new IllegalDateException(IllegalDateException.DAY_ILLEGAL);
                    }
                    break;
                default:
                    throw new IllegalDateException(IllegalDateException.MON_ILLEGAL);
            }
        }else{
            throw new IllegalDateException(IllegalDateException.STRING_FORMAT_ILLEGAL);
        }

        return isValid;
    }

    @Override
    public String toString(){
        return this.year + "-" + ((this.mon < 10) ? ("0" + this.mon): this.mon) + "-" + ((this.day < 10) ? ("0" + this.day): this.day);
    }
}
