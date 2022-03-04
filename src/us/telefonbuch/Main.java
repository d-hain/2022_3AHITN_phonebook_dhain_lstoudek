package us.telefonbuch;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, IllegalPhoneNumberException, CloneNotSupportedException{
        File f = new File("src/us/telefonbuch/Person.csv");
        BufferedReader br = new BufferedReader(new FileReader(f));
        ArrayList<Person> list = new ArrayList<>();
        StreamOperation so = new StreamOperation();
        Person p;
        do{
            p = so.FromStream(br);
            if(p != null){
                list.add(p);
            }
        }while(p != null);


    }
}
