import java.io.*;

public abstract class Bank implements Serializable {

    String Name;
    String Ic;
    String PhoneNum;
    String Email;
    public static final long serialVersionUID = 42L;

    public Bank() {
        Name = "";
        Ic = "";
        PhoneNum = "";
        Email = "";
    }

    public Bank(String n, String i, String p, String e) {
        Name = n;
        Ic = i;
        PhoneNum = p;
        Email = e;
    }

    public void setBank(String n, String i, String p, String e) {
        Name = n;
        Ic = i;
        PhoneNum = p;
        Email = e;
    }

    public String getName() {
        return Name;
    }

    public String getIC() {
        return Ic;
    }

    public String getPhone() {
        return PhoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public abstract double calculateBonus();

    public String toString() {
        return getName() + "\t" + getIC() + "\t" + getPhone() + "\t" + getEmail();
    }
}
