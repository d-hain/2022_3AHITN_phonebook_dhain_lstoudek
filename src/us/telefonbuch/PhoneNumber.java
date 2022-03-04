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
        if (isValid(s[0].substring(1), s[1],  s[2])) {
            if (s[0].contains("+")) {
                this.country = Integer.parseInt(s[0].substring(1));
            } else {
                this.country = Integer.parseInt(s[0]);
            }
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
        try {
            if (Integer.parseInt(country) >= 1000) {
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.COUNTRY_ILLEGAL);
            }
            if (Integer.parseInt(areacode) >= 10000) {
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.AREA_ILLEGAL);
            }if (Double.parseDouble(number) >= 2147483647){
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.NUMBER_ILLEGAL);
            }

        }catch (IllegalPhoneNumberException e){
            System.out.println(e.type);
        }
        return true;
    }
}
