/**
 * Exeption for an illegal phone number
 *
 * @author Leonhard Stoudek
 */

package us.telefonbuch;

public class IllegalPhoneNumberException {
    private int type;
    public int COUNTRY_ILLEGAL;
    public int AREA_ILLEGAL;
    public int NUMBER_ILLEGAL;
    public int STRING_FORMAT_ILLEGAL;

    IllegalPhoneNumberException(int type){
        this.type = type;
    }



}
