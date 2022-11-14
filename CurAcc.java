import java.io.*;

public class CurAcc extends Account implements Serializable {

    double overdraft;

    public CurAcc() {

        super();
        overdraft = 0.0;
    }

    public CurAcc(String n, String i, String p, String e, String a, int pi, double b, int d, String m, int y,boolean c, double o) {

        super(n, i, p, e, a, pi, b, d, m, y,c);
        overdraft = o;

    }
    
    public void setCurAcc(String n, String i, String p, String e, String a, int pi, double b, int d, String m, int y,boolean c, double o) {

        super.setAccount(n, i, p, e, a, pi, b, d, m, y,c);
        overdraft = o;

    }
    
    public double getOverdraft()
    {
      return overdraft;
    }
    
    public String toString()
    {
      return super.toString() + "\t" + getOverdraft();
    }

}
