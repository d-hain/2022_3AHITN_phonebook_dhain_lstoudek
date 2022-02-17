package us.telefonbuch;

public class IllegalDateException extends Exception{
    private int type;
    public int DAY_ILLEGAL;
    public int MON_ILLEGAL;

    public IllegalDateException(int type){

    }
}
