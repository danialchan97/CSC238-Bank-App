import java.io.*;

public class Manager extends Bank implements Serializable {

    int Id;
    String Password;
    String Position;
    double Salary;

    public Manager() {
        super();
        Id = 0;
        Password = " ";
        Position = " ";
        Salary = 0.0;
    }

    public Manager(String n, String i, String p, String e, int id, String pa, String po, double s) {
        super(n, i, p, e);
        Id = id;
        Password = pa;
        Position = po;
        Salary = s;
    }

    public void setManager(String n, String i, String p, String e, int id, String pa, String po, double s) {
        super.setBank(n, i, p, e);
        Id = id;
        Password = pa;
        Position = po;
        Salary = s;
    }

    public int getID() {
        return Id;
    }

    public String getPassword() {
        return Password;
    }

    public String getPosition() {
        return Position;
    }

    public double getSalary() {
        return Salary;
    }

    public double calculateBonus() {
        double b = 0;

        if (getPosition().equalsIgnoreCase("CEO")) {
            b = 1000;
        }

        return b;
    }

    public String toString() {
        return super.toString()+"\t"+getID() + "\t" + getPassword() + "\t" + getPosition() + "\t" + getSalary();
    }
}
