/**
 * Exeption for an illegal phone number
 *
 * @author Leonhard Stoudek
 */

package us.telefonbuch;

public class IllegalPhoneNumberException extends Throwable {
    public int type;
    public static int COUNTRY_ILLEGAL = 0;
    public static int AREA_ILLEGAL = 1;
    public static int NUMBER_ILLEGAL = 2;
    public static int STRING_FORMAT_ILLEGAL = 3;
    private final String ESCAPE = "\u001B[0m";
    private final String RED = "\u001B[31m";

    IllegalPhoneNumberException(int type){
        System.out.println(RED);
        this.type = type;
        if (this.type == COUNTRY_ILLEGAL){
            System.out.println("No valid countycode!");
        }else if(this.type == AREA_ILLEGAL){
            System.out.println("No valid Areacode!");
        } else if (this.type == NUMBER_ILLEGAL){
            System.out.println("No valid Number!");
        } else if (this.type == STRING_FORMAT_ILLEGAL){
            System.out.println("No valid String Format!");
        }
        System.out.println(ESCAPE);
    }




}
