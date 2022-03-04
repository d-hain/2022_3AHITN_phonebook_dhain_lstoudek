/**
 *  Writes or reads a Person into or from a File
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

public class StreamOperation  {

        public void ToStream(Writer w, Person p) throws IOException {
            w.append(p.toString());
        }

        public Person FromStream(BufferedReader br) throws IOException, IllegalPhoneNumberException, CloneNotSupportedException {
            String[] s = br.readLine().split(";");
            String[] s1 = s[3].split("-");
            return new Person(s[0], s[1], s[2], new Date(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0])), new PhoneNumber(s[4]+s[5]));
        }
}
