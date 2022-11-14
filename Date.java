import java.io.*;

public class Date implements Serializable {

    int day;
    String month;
    int year;

    public Date() {
        day = 0;
        month = " ";
        year = 0;
    }

    public Date(int d, String m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public void setDate(int d, String m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    public String toString()
    {
        return getDay()+"/"+getMonth()+"/"+getYear();
    }

}
