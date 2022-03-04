/**
 * saves a Person with name, nickname, givenname, birthday and phone
 * has a toString
 *
 * @author Leonhard Stoudek
 */

package us.telefonbuch;

public class Person {
    private String name;
    private String givenname;
    private String nickname;
    private Date birthday;
    private PhoneNumber phone;

    public Person(String n, String nn, String gn, Date bd, PhoneNumber p){
        this.name = n;
        this.nickname = nn;
        this.givenname = gn;
        this.birthday = bd;
        this.phone = p;
    }

    @Override
    public String toString() {
        return name + " " + nickname + " " + givenname + " " + birthday.toString() + " " + phone;
    }
}
