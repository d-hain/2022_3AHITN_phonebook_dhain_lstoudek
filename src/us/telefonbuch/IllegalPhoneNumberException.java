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

    IllegalPhoneNumberException(int type){
        this.type = type;

    }



}
