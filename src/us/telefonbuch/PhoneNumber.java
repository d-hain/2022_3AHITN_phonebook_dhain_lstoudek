/**
 * Saves Phone Number in country, areacode and number
 * can check if Phonenumber isValid
 * has a toString methode
 *
 * @author Leonhard Stoudek
 */

package us.telefonbuch;

import java.awt.*;
import java.util.regex.Pattern;

public class PhoneNumber {
    private int country;
    private int areacode;
    private int number;

    PhoneNumber(int c, int a, int n){
        country = c;
        areacode = a;
        number = n;
    }

    PhoneNumber(String number) throws IllegalPhoneNumberException, CloneNotSupportedException{
        Pattern pattern = Pattern.compile("\\D");
        String[] s = number.split(pattern.pattern());
        if (isValid(s[0], s[1],  s[2])) {
            this.country = Integer.parseInt(s[0]);
            this.areacode = Integer.parseInt(s[1]);
            this.number = Integer.parseInt(s[2]);
        }
    }

    public int getAreacode() {
        return areacode;
    }

    public int getCountry() {
        return country;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "+" + country + " " + areacode + " /" + number;
    }

    public boolean isValid(String country, String areacode, String number ) throws IllegalPhoneNumberException{
        boolean rv = true;
        if (country.matches("[0-9]+"))

        if (Integer.parseInt(country) >= 1000) {
            rv = false;
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.COUNTRY_ILLEGAL);
            }
            if (Integer.parseInt(areacode) >= 10000) {
                rv = false;
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.AREA_ILLEGAL);
            }if (Double.parseDouble(number) >= 2147483647){
            rv = false;
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.NUMBER_ILLEGAL);
            }
            return rv;
    }
}
