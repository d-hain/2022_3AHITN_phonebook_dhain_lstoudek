/**
 * Saves Phone Number + checks if it is valid
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

    PhoneNumber(String number){
        Pattern pattern = Pattern.compile(" ");
        String[] s = number.split(pattern.pattern());
        if (s[0].contains("+")){
            country = Integer.parseInt(s[0].substring(1));
        } else {
            country = Integer.parseInt(s[0]);
        }
        areacode = Integer.parseInt(s[1]);
        this.number = Integer.parseInt(s[2]);
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

    public boolean isValid(PhoneNumber phoneNumber) throws IllegalPhoneNumberException{
        try {
            if (country >= 1000) {
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.COUNTRY_ILLEGAL);
            }
            if (areacode >= 10000) {
                throw new IllegalPhoneNumberException(IllegalPhoneNumberException.AREA_ILLEGAL);
            }

        }catch (IllegalPhoneNumberException e){
            System.out.println(e.type);
        }
        return true;
    }
}
