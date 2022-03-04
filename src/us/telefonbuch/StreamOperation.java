/**
 * Writes or reads a Person into or from a File
 * ToStream writes in a file
 * FromStream reads from a file and creates a Person
 *
 * @author Leonhard Stoudek
 */

package us.telefonbuch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class StreamOperation{

    /**
     * Writes Person into Writer
     * @param w Writer
     * @param p Person
     * @throws IOException
     */
    public void ToStream(Writer w, Person p) throws IOException{
        w.append(p.toString());
    }

    /**
     * Converts line from BufferedReader to Person
     * @param br BufferedReader
     * @return Person
     * @throws IOException
     * @throws IllegalPhoneNumberException
     * @throws CloneNotSupportedException
     */
    public Person FromStream(BufferedReader br) throws IOException, IllegalPhoneNumberException, CloneNotSupportedException{
        String line = br.readLine();
        if(line.equals("")){
            return null;
        } else{
            String[] s = br.readLine().split(";");
            String[] s1 = s[3].split("-");
            return new Person(s[0], s[1], s[2], new Date(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0])), new PhoneNumber(s[4] + s[5]));
        }
    }
}
