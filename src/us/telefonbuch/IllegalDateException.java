/**
 * Exception when date is not correct
 *
 * @author David Hain
 */

package us.telefonbuch;

public class IllegalDateException extends Exception{
    private int type;
    public static int DAY_ILLEGAL = 0;
    public static int MON_ILLEGAL = 1;
    public static int STRING_FORMAT_ILLEGAL = 2;
    private final String ESCAPE = "\u001B[0m";
    private final String RED = "\u001B[31m";

    public IllegalDateException(int type){
        this.type = type;
        if(type == DAY_ILLEGAL){
            System.out.println(RED + "Illegal Day" + ESCAPE);
        } else if(type == MON_ILLEGAL){
            System.out.println(RED + "Illegal Month" + ESCAPE);
        } else if(type == STRING_FORMAT_ILLEGAL){
            System.out.println(RED + "Illegal String Format" + ESCAPE);
        } else{
            System.out.println(RED + "Illegal Type given" + ESCAPE);
        }
    }
}
