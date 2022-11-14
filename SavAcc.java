import java.io.*;

public class SavAcc extends Account implements Serializable {

    double interest;

    public SavAcc() {
        super();
        interest = 0.0;
    }

    public SavAcc(String n, String i, String p, String e, String a, int pi, double b, int d, String m, int y,boolean c, double in) {
        super(n, i, p, e, a, pi, b, d, m, y,c);
        interest = in;
    }

    public void setSavAcc(String n, String i, String p, String e, String a, int pi, double b, int d, String m, int y,boolean c, double in) {
        super.setAccount(n, i, p, e, a, pi, b, d, m, y,c);
        interest = in;
    }

    public double getInterest() {
        return interest;
    }

    public double calculateInterest() {
        balance = balance + (balance * interest);
        return balance;
    }
    
    public String toString()
    {
      return super.toString() + "\t" + getInterest();
    }
}
