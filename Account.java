import java.io.*;
public class Account extends Bank implements Serializable{

    String accNo;
    int pin;
    double balance;
    Date date;
    boolean Cpin;

    public Account() {
        super();
        accNo = " ";
        pin = 0;
        balance = 0.0;
        date = new Date(0, " ", 0);
        Cpin = false;
    }

    public Account(String n, String i, String p, String e, String a, int pi, double b, int d, String m, int y, boolean c) {
        super(n, i, p, e);
        accNo = a;
        pin = pi;
        balance = b;
        date = new Date(d, m, y);
        Cpin = c;
    }

    public void setAccount(String n, String i, String p, String e, String a, int pi, double b, int d, String m, int y, boolean c) {
        super.setBank(n, i, p, e);
        accNo = a;
        pin = pi;
        balance = b;
        date.setDate(d, m, y);
        Cpin = c;
    }

    public String getAcc() {
        return accNo;
    }

    public int getPin() {
        return pin;
    }

    public double getBal() {
        return balance;
    }

    public Date getDate() {
        return date;
    }
    
    public boolean getCpin() {
        return Cpin;
    }

    public double calculateBonus() {

        if (date.getDay() == 31 && date.getMonth().equalsIgnoreCase("december")) {

            double balance;
            balance = getBal() + 500;

        }
        return balance;

    }
    
    public String toString()
    {
        return super.toString()+"\t"+getAcc()+"\t"+getPin()+"\t"+getBal()+"\t"+date.toString() + "\t" + getCpin();
    }

}
