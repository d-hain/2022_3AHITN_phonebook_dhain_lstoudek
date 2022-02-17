/**
 * Exception when date is not correct
 * @author David Hain
 */

package us.telefonbuch;

public class IllegalDateException extends Exception{
    private int type;
    public static int DAY_ILLEGAL = 0;
    public static int MON_ILLEGAL = 1;

    public IllegalDateException(int type){
        this.type = type;
    }
}
