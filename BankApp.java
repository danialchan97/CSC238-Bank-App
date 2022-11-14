import java.util.*;
import java.io.*;

public class BankApp {

   public static void main(String[] args) throws IOException {
   
      Scanner a = new Scanner(System.in);
      Scanner s = new Scanner(System.in).useDelimiter("//s");
      char choice;
      char con;
      ArrayList<Bank> list = new ArrayList<Bank>();
   
      String menu = ""; boolean Man = false;
   
      int y;
      int x;
      char con1;
      
      list = Read(list);
      
      for(x = 0; x < list.size(); x++)
      {   
         if(list.get(x) instanceof Manager)
            Man = true;
      }
   
      if(!Man)
      {   
         System.out.println("Please enter the First Manager First");
         inputM(list);
      }
       
      do {
      
         System.out.println(list.size());
      
         Menu();
      
         con1 = a.next().charAt(0);
      
         if (con1 == 'M' || con1 == 'm') {
         
            String pass;
            int id;
            boolean cond = false;
            int d; int loc = 0;
            int index = 0;
            int count = 3;
            boolean ada = false;
         
            System.out.print("ID: ");
            id = a.nextInt();
            System.out.println("PASSWORD:   ");
            pass = s.nextLine();
            
            
            for( x = 0; x < 3; x++){
            
               for(d = 0; d < list.size(); d++){
            
                  if(list.get(d)instanceof Manager){
                  
                     Manager temp =(Manager) list.get(d);
                     if(temp.getID() == id){
                        ada = true;
                        loc = d;
                  }
                }
               }
               if(!ada)
               {
                  System.out.println("WRONG ID/PASSWORD");
                  count--;
                  
                  if (count != 0){
                     System.out.println((count)+" TRY LEFT!!");
                     System.out.print("ID: ");
                     id = a.nextInt();
                     System.out.println("PASSWORD:   ");
                     pass = s.nextLine();
                   }
                   
                   else{
                     System.out.println("THE SYSTEM WILL NOW TERMINATE!!!");
                     System.exit(0);
                  }
                  
                  
                  for(d = 0; d < list.size(); d++){
            
                  if(list.get(d)instanceof Manager){
                  
                     Manager temp =(Manager) list.get(d);
                     if(temp.getID() == id){
                        ada = true;
                        loc = d;
                  }
                }
               }
              }
               if(list.get(loc)instanceof Manager){
                  Manager temp =(Manager) list.get(loc);
                  if(temp.getPassword().equals(pass)){
                     cond = true;
                     index = loc;
                }
              
               else{
                  System.out.println("WRONG ID/PASSWORD");
                  count--;
                  if(count != 0){
                     System.out.println((count)+" TRY LEFT!!");
                     System.out.print("ID: ");
                     id = a.nextInt();
                     System.out.println("PASSWORD:   ");
                     pass = s.nextLine();
                 }
                 else{
                     System.out.println("THE SYSTEM WILL NOW TERMINATE!!!");
                     System.exit(0);
              }
           }
         }
        }
                     
           if (cond) {
            
               Manager m = (Manager) list.get(index);
               String W = "Log in to the System";
               
               Log(list,index,W);
            
               System.out.println("WELCOME " + m.getName());
               System.out.print("\n");
               MenuM();
            
               System.out.println("Please enter your choice");
               menu = s.nextLine();
               if (menu.equalsIgnoreCase("ED")) {
                  System.out.println("M - Manager     C - Customer  ");
                  choice = a.next().charAt(0);
               
                  if (choice == 'C' || choice == 'c') {
                     inputC(list);
                  } 
                  else {
                     inputM(list);
                  }
               } 
               else if (menu.equalsIgnoreCase("RE")) {
                  list = Remove(list,index);
               } 
               else if (menu.equalsIgnoreCase("UP")) {
                  list = Update(list);
               }
            
         
         }
        } 
         else if (con1 == 'C' || con1 == 'c') {
            String acc;
         
            int pin; int loc = 0;
            int d;
            boolean cond = false;
            int index = 0;
            int count = 3;
            boolean ada = false;
         
            System.out.print("ACCOUNT NUMBER: ");
            acc = s.nextLine();
            System.out.print("PIN: ");
            pin = a.nextInt();
            
            
            for( x = 0; x < 3; x++){
            
               for(d = 0; d < list.size(); d++){
            
                  if(list.get(d)instanceof Account){
                  
                     Account temp =(Account) list.get(d);
                     if(temp.getAcc().equals(acc)){
                        ada = true;
                        loc = d;
                  }
                }
               }
               if(!ada)
               {
                  System.out.println("WRONG ACCOUNT NUMBER/PIN");
                  count--;
                  
                  if (count != 0){
                     System.out.println((count)+" TRY LEFT!!");
                     System.out.print("ACCOUNT NUMBER: ");
                     acc = s.nextLine();
                     System.out.print("PIN: ");
                     pin = a.nextInt();
                   }
                   
                   else{
                     System.out.println("THE SYSTEM WILL NOW TERMINATE!!!");
                     System.exit(0);
                  }
                  
                  
                  for(d = 0; d < list.size(); d++){
            
                  if(list.get(d)instanceof Account){
                  
                     Account temp =(Account) list.get(d);
                     if(temp.getAcc().equals(acc)){
                        ada = true;
                        loc = d;
                  }
                }
               }
              }
               if(list.get(loc)instanceof Account){
                  Account temp =(Account) list.get(loc);
                  if(temp.getPin() == pin){
                     cond = true;
                     index = loc;
                }
              
               else{
                  System.out.println("WRONG ACCOUNT NUMBER/PIN");
                  count--;
                  if(count != 0){
                     System.out.println((count)+" TRY LEFT!!");
                     System.out.print("ACCOUNT NUMBER: ");
                     acc = s.nextLine();
                     System.out.print("PIN: ");
                     pin = a.nextInt();
                 }
                 else{
                     System.out.println("THE SYSTEM WILL NOW TERMINATE!!!");
                     System.exit(0);
              }
           }
         }
        }         
            if (cond) {
               String w = "Log in to the System";
               
               Log(list,index,w);
               MenuC();
            
               System.out.println("Please enter your choice");
               menu = s.nextLine();
            
               if (menu.equalsIgnoreCase("CW")) {
                  CashWithdraw(list, index);
               } 
               else if (menu.equalsIgnoreCase("TM")) {
                  transfer(list, index);
               } 
               else if (menu.equalsIgnoreCase("CB")) {
                  checkBal(list, index);
               }
            
             }
           } 
         
         else {
            System.out.println("Invalid Choice");
         }
      
         System.out.println("Do you want to continue?    ");
         System.err.println("Yes - Y     No - N");
         con = a.next().charAt(0);
      
      } while (con == 'Y' || con == 'y');
   
      Write(list);
   
      for (x = 0; x < list.size(); x++) {
         System.out.println(list.get(x).toString());
      }
   
   }//End of Main

   
   
   // input for first manager
   public static ArrayList<Bank> inputFirst(ArrayList<Bank> list) {
   
      String Name, Ic, PhoneNum, Email, accNo, month, Password, Position;
      int pin, day, year, Id;
      double balance, Salary, interest, overdraft;
      char type;
   
      Scanner a = new Scanner(System.in);
      Scanner s = new Scanner(System.in).useDelimiter("//s");
   
      int x;
   
      System.out.println("Enter name  ");
      Name = s.nextLine();
      System.out.println("Enter IC  ");
      Ic = s.nextLine();
      System.out.println("Enter Phone Number  ");
      PhoneNum = s.nextLine();
      System.out.println("Enter Email  ");
      Email = s.nextLine();
      System.out.println("Enter ID  ");
      Id = a.nextInt();
      System.out.println("Enter Password ");
      Password = s.nextLine();
      System.out.println("Enter Position   ");
      Position = s.nextLine();
      System.out.println("Enter Salary  ");
      Salary = a.nextDouble();
   
      Bank acc = new Manager(Name, Ic, PhoneNum, Email, Id, Password, Position, Salary);
   
      list.add(acc);
   
      return list;
   
   }
   
   //MAIN MENU
   public static void Menu() {
      String welcome = "$$$ WELCOME TO CIACIA BANK $$$ ";
   
      for (int x = 0; x < welcome.length(); x++) {
         System.out.print(welcome.substring(x, x + 1));
      
         try {
            Thread.sleep(100);
         } 
         catch (Exception e) {
            e.getMessage();
         }
      
      }
      System.out.print("\n");
      System.out.println("__________________________");
      System.out.println("Manager (M)   Customer (C)");
      System.out.println("__________________________");
   
   }

   //MENUUUUUUUUUUUUUUU
   public static void MenuM() {
      Scanner a = new Scanner(System.in);
      Scanner s = new Scanner(System.in).useDelimiter("//s");
      System.out.println("            $$$Welcome to CiaCiaCia Bank$$$                 ");
      System.out.println("=========================================================");
      System.out.println("                  Enter Data(ED)                          ");
      System.out.println("                  Remove(RE)                          ");
      System.out.println("                  Update(UP)                           ");
      System.out.println("=========================================================");
   }

   public static void MenuC() {
   
      String welcome = "$$$ WELCOME TO CIACIA BANK $$$ ";
   
      for (int x = 0; x < welcome.length(); x++) {
         System.out.print(welcome.substring(x, x + 1));
      
         try {
            Thread.sleep(100);
         } 
         catch (Exception e) {
            e.getMessage();
         }
        }
         System.out.println();
         System.out.println("=========================================================");
         System.out.println("                  Cash Withdrawal(CW)                          ");
         System.out.println("                  Transfer Money(TM)                          ");
         System.out.println("                  Check Balance(CB)                           ");
         System.out.println("=========================================================");
      
      }
      

   @SuppressWarnings("unchecked")
   public static ArrayList<Bank> Read(ArrayList<Bank> list)//READ DATA FROM FILE
   {
      try {
      
         FileInputStream fis = new FileInputStream("Data.dat");
         ObjectInputStream in = new ObjectInputStream(fis);
      
         list = (ArrayList<Bank>) in.readObject();
         in.close();
      } 
      catch (FileNotFoundException fnfe) {
         System.out.println(fnfe.getMessage());
      } 
      catch (IOException ioe) {
         System.out.println(ioe.getMessage());
      } 
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
   
      return list;
   }

   public static void Write(ArrayList<Bank> list)//WRITE DATA TO FILE
   {
      try {
         FileOutputStream fos = new FileOutputStream("Data.dat");
         ObjectOutputStream out = new ObjectOutputStream(fos);
      
         out.writeObject(list);
         out.close();
      } 
      catch (FileNotFoundException fnfe) {
         System.out.println(fnfe.getMessage());
      } 
      catch (IOException ioe) {
         System.out.println(ioe.getMessage());
      } 
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   public static ArrayList<Bank> Remove(ArrayList<Bank> list, int index)//REMOVE PERSON
   {
      System.out.println("Please enter the IC number that you want to remove");
      Scanner a = new Scanner(System.in).useDelimiter("//s");
      String ic;
      int x;
      int obj = 0; boolean found = false;
      ic = a.nextLine();
      String W = "Removed ";
      String W1 = "";
      String W2 = " With the IC of ";
      String W3 = "";
      String W4 =" From the System";
   
      for (x = 0; x < list.size(); x++) {
      
         if (ic.equalsIgnoreCase(list.get(x).getIC())) {
            obj = x;
            found = true;
            System.out.println(list.get(x).getName() + " Has Been Removed");
            W1 = list.get(x).getName();
            W3 = list.get(x).getIC();
            String W5 = W + W1 + W2 + W3 + W4;
            Log(list,index,W5);
            list.remove(obj);
         
         }
       }
       if(!found)
         System.out.println("No data Found");
   
      return list;
   }

   public static ArrayList<Bank> Update(ArrayList<Bank> list)//UPDATE DATA
   {
      String ic = null;
      int x;
      int obj;
      String c;
      boolean found = false;
      System.out.println("Please enter IC Number");
      Scanner a = new Scanner(System.in);
      ic = a.nextLine();
      for (x = 0; x < list.size(); x++) {
         if (ic.equalsIgnoreCase(list.get(x).getIC())) {
            System.out.println("Entries Found");
            found = true;
            System.out.println("Please choose what you want to Update");
            UpdMenu(list.get(x));
            c = a.nextLine();
            if (c.equalsIgnoreCase("NA")) {
               System.out.println("Enter Your new Name");
               String name = a.nextLine();
               list.get(x).setBank(name, list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail());
               System.out.println("Your name has been updated");
            } 
            else if (c.equalsIgnoreCase("PN")) {
               System.out.println("Enter Your new Phone Number");
               String number = a.nextLine();
               list.get(x).setBank(list.get(x).getName(), list.get(x).getIC(), number, list.get(x).getEmail());
               System.out.println("Your name has been updated");
            } 
            else if (c.equalsIgnoreCase("EM")) {
               System.out.println("Enter Your new Email");
               String Email = a.nextLine();
               list.get(x).setBank(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), Email);
               System.out.println("Your name has been updated");
            } 
            else if (c.equalsIgnoreCase("AN")) {
               System.out.println("Please enter your new Account Number");
               String num = a.nextLine();
               Account temp = new Account();
               temp = (Account) list.get(x);
               temp.setAccount(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                      num, temp.getPin(), temp.getBal(), temp.getDate().getDay(), temp.getDate().getMonth(),
                      temp.getDate().getYear());
               list.set(x, temp);
               System.out.println("Your account number has been updated");
            } 
            else if (c.equalsIgnoreCase("PIN")) {
               System.out.println("Please enter your new PIN");
               int pin = a.nextInt();
               Account temp = new Account();
               temp = (Account) list.get(x);
               temp.setAccount(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                      temp.getAcc(), pin, temp.getBal(), temp.getDate().getDay(), temp.getDate().getMonth(),
                      temp.getDate().getYear());
               list.set(x, temp);
               System.out.println("Your PIN has been updated");
            } 
            else if (c.equalsIgnoreCase("ID")) {
               System.out.println("Please enter your new PIN");
               int id = a.nextInt();
               Manager temp = new Manager();
               temp = (Manager) list.get(x);
               temp.setManager(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                      id, temp.getPassword(), temp.getPosition(), temp.getSalary());
               list.set(x, temp);
               System.out.println("Your ID has been updated");
            } 
            else if (c.equalsIgnoreCase("PW")) {
               System.out.println("Please enter your new Password");
               String pass = a.nextLine();
               Manager temp = new Manager();
               temp = (Manager) list.get(x);
               temp.setManager(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                      temp.getID(), pass, temp.getPosition(), temp.getSalary());
               list.set(x, temp);
               System.out.println("Your Password has been updated");
            } 
            else if (c.equalsIgnoreCase("POS")) {
               System.out.println("Please enter your new Position");
               String pos = a.nextLine();
               Manager temp = new Manager();
               temp = (Manager) list.get(x);
               temp.setManager(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                      temp.getID(), temp.getPassword(), pos, temp.getSalary());
               list.set(x, temp);
               System.out.println("Your Position has been updated");
            } 
            else if (c.equalsIgnoreCase("SAL")) {
               System.out.println("Please enter your new Salary");
               double sal = a.nextDouble();
               Manager temp = new Manager();
               temp = (Manager) list.get(x);
               temp.setManager(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                      temp.getID(), temp.getPassword(), temp.getPosition(), sal);
               list.set(x, temp);
               System.out.println("Your Salary has been updated");
            }
         }
      
      }
   
      if (!found) {
         System.out.println("No Entries with such IC found");
      }
   
      return list;
   }

   //INPUT DATA FOR USER         
   public static ArrayList<Bank> inputC(ArrayList<Bank> list) {
   
      String Name, Ic, PhoneNum, Email, accNo, month, Password, Position;
      int pin, day, year, Id;
      double balance, Salary, interest = 0.05, overdraft = 0.0;
      char type;
   
      Scanner ac = new Scanner(System.in);
      Scanner sc = new Scanner(System.in).useDelimiter("//s");
   
      int x;
   
      System.out.println("Enter name  ");
      Name = sc.nextLine();
      System.out.println("Enter IC  ");
      Ic = sc.nextLine();
      System.out.println("Enter Phone Number  ");
      PhoneNum = sc.nextLine();
      System.out.println("Enter Email  ");
      Email = sc.nextLine();
      System.out.println("Enter account number  ");
      accNo = sc.nextLine();
   
      for (x = 0; x < list.size(); x++) {
         if(list.get(x) instanceof Account)
         {
         
            Account temp = new Account();
            temp = (Account) list.get(x);
         
            if (accNo.equalsIgnoreCase(temp.getAcc())) {
               System.out.print("ERROR: ACCOUNT NUMBER CANNOT BE SAME  ");
               x--;
               System.out.println("Enter account number  ");
               accNo = sc.nextLine();
            }
         
         }
      }
   
      System.out.println("Enter pin ");
      pin = ac.nextInt();
      System.out.println("Enter Balance   ");
      balance = ac.nextDouble();
      System.out.println("Enter date   ");
      day = ac.nextInt();
      month = sc.nextLine();
      year = ac.nextInt();
   
      System.out.println("Saving account - S    Current Account - C  ");
      type = ac.next().charAt(0);
      if (type == 'S') {
         Bank acc = new SavAcc(Name, Ic, PhoneNum, Email, accNo, pin, balance, day, month, year, interest);
         list.add(acc);
      } 
      else if (type == 'C') {
         System.out.println("Please enter your overdraft");
         Bank acc = new CurAcc(Name, Ic, PhoneNum, Email, accNo, pin, balance, day, month, year, overdraft);
         list.add(acc);
      }
   
      return list;
   
   }
   //INPUT DATA FOR MANAGER

   public static ArrayList<Bank> inputM(ArrayList<Bank> list) {
   
      String Name, Ic, PhoneNum, Email, accNo, month, Password, Position;
      int pin, day, year, Id;
      double Salary;
      char type;
   
      Scanner a = new Scanner(System.in);
      Scanner s = new Scanner(System.in).useDelimiter("//s");
   
      int x;
   
      System.out.println("Enter name  ");
      Name = s.nextLine();
      System.out.println("Enter IC  ");
      Ic = s.nextLine();
      System.out.println("Enter Phone Number  ");
      PhoneNum = s.nextLine();
      System.out.println("Enter Email  ");
      Email = s.nextLine();
      System.out.println("Enter ID  ");
      Id = a.nextInt();
      
      for (x = 0; x < list.size(); x++) {
         if(list.get(x) instanceof Manager)
         {
            Manager temp = new Manager();
            temp = (Manager) list.get(x);
         
            if (Id == temp.getID()) {
               System.out.print("ERROR: ID CANNOT BE SAME  ");
               x--;
               System.out.println("Enter ID  ");
               Id = a.nextInt();
            }
         
         }
      }
      System.out.println("Enter Password ");
      Password = s.nextLine();
      System.out.println("Enter Position   ");
      Position = s.nextLine();
      System.out.println("Enter Salary  ");
      Salary = a.nextDouble();
   
      Bank acc = new Manager(Name, Ic, PhoneNum, Email, Id, Password, Position, Salary);
   
      list.add(acc);
   
      return list;
   
   }

   public static void UpdMenu(Bank list)//UPDATE MENU
   {
      System.out.println("=============================================");
      System.out.println("Name(NA)                      ");
      System.out.println("Phone Number(PN)                      ");
      System.out.println("Email(EM)                      ");
   
      if (list instanceof Account) {
         System.out.println("Account Number(AN)                      ");
         System.out.println("Pin(PIN)                      ");
         System.out.println("Balance(BAL)                      ");
         System.out.println("============================================");
      } 
      else if (list instanceof Manager) {
         System.out.println("ID(ID)                      ");
         System.out.println("Password(PW)                      ");
         System.out.println("Position(POS)                      ");
         System.out.println("Salary(SAL)                      ");
         System.out.println("============================================");
      }
   }

   /**
    *
    * @param list
    * @param index
    * @return
    */
   //CASH WITHDRAW
   public static ArrayList<Bank> CashWithdraw(ArrayList<Bank> list, int index) {
      System.out.println("RM 50             RM 100");
      System.out.println("RM 150            RM 300");
      System.out.println("RM 500            RM 1000");
      System.out.println("Other (7)   ");
   
      Scanner a = new Scanner(System.in);
      int amount;
      double money = 0;
   
      amount = a.nextInt();
   
      if (amount == 7) {
         System.out.print("Enter amount of cash  ");
         money = a.nextDouble();
      
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - money;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      
      } 
      else if (amount == 50) {
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - 50;
         money = 50;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      
      } 
      else if (amount == 100) {
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - 100;
         money = 100;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      } 
      else if (amount == 150) {
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - 150;
         money = 150;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      } 
      else if (amount == 300) {
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - 300;
         money = 300;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      } 
      else if (amount == 500) {
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - 500;
         money = 500;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      } 
      else if (amount == 1000) {
         double n;
         Account temp = new Account();
      
         temp = (Account) list.get(index);
         n = temp.getBal() - 1000;
         money = 1000;
      
         temp.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                temp.getDate().getYear());
         list.set(index, temp);
      }
      String w = "Withdraw a cash of RM";
      String w1 = Double.toString(money);
      String w2 = w + w1;
      
      Log(list,index,w2);
      receipt(list, index);
      return list;
   
   }

   //RECEIPT
   public static void receipt(ArrayList<Bank> list, int index) {
   
      Account temp = new Account();
   
      temp = (Account) list.get(index);
   
      System.out.println("==========================");
      System.out.println("CIA CIA CIA BANK          ");
      System.out.println("ACC NO:    " + temp.getAcc());
      System.out.println("BALANCE:    " + temp.getBal());
      System.out.println("==========================");
   
   }

   // TRANSFER MONEY
   public static ArrayList<Bank> transfer(ArrayList<Bank> list, int index) {
      String acc;
      double amount;
   
      int x,index2 = 0;
      double n;
      double n1;
   
      Scanner a = new Scanner(System.in);
      Scanner s = new Scanner(System.in).useDelimiter("//s");
      System.out.println("Account number to transfer    ");
      acc = s.nextLine();
      System.out.print("Amount of cash to transfer  RM    ");
      amount = a.nextDouble();
   
      Account temp = new Account();
      Account temp1 = new Account();
   
      temp1 = (Account) list.get(index);
   
      if (amount > temp1.getBal()) {
         System.out.print("NOT ENOUGH MONEY");
      } 
      else {
      
         for (x = 0; x < list.size(); x++) {
            
            if(list.get(x)instanceof Account)
            {
         
               temp = (Account) list.get(x);
         
               if (acc.equalsIgnoreCase(temp.getAcc())) {
                  index2 = x;
                  n = temp.getBal() + amount;
            
                  temp.setAccount(list.get(x).getName(), list.get(x).getIC(), list.get(x).getPhone(), list.get(x).getEmail(),
                        temp.getAcc(), temp.getPin(), n, temp.getDate().getDay(), temp.getDate().getMonth(),
                        temp.getDate().getYear());
                  list.set(x, temp);
            
                  n1 = temp1.getBal() - amount;
            
                  temp1.setAccount(list.get(index).getName(), list.get(index).getIC(), list.get(index).getPhone(), list.get(index).getEmail(),
                        temp1.getAcc(), temp1.getPin(), n1, temp1.getDate().getDay(), temp1.getDate().getMonth(),
                        temp1.getDate().getYear());
                  list.set(index, temp1);
                }
                
                
                
            
            }
         }
                temp = (Account) list.get(index2);
                
                String w1 = "Received Rm";//Receiver
                String w2 = Double.toString(amount);
                String w3 = " From ";
                String w4 = temp1.getName();
                String w5 = " With Account Number of ";
                String w6 = temp1.getAcc();
                String w = w1 + w2 + w3 + w4 + w5 + w6;
                
                String e1 = "Transfer RM";//Giver
                String e2 = Double.toString(amount);
                String e3 = " To ";
                String e4 = temp.getName();
                String e5 = " With Account Number of ";
                String e6 = temp.getAcc();
                String e = e1 + e2 + e3 + e4 + e5 + e6;
                
                Log(list,index,index2,w,e);
      
      }
   
      return list;
   }

   public static void checkBal(ArrayList<Bank> list, int index) {
      Account temp = new Account();
   
      temp = (Account) list.get(index);
   
      System.out.println("=====================");
      System.out.println("CIA CIA CIA BANK    ");
      System.out.println("=======================");
      System.out.println("Account Number: " + temp.getAcc());
      System.out.println("Balance:    RM " + temp.getBal());
      String w2 = "Check Balance";
      
      Log(list,index,w2);
   
   
   }
   public static void Log(ArrayList<Bank> list, int index, String w)
   {  
      String a = ""; String a2 = list.get(index).getName(); String a3 = ",";
      String a4 = ""; String a5 = ").txt";
         
      if(list.get(index) instanceof Account)
      {
         Account temp = new Account();
         temp = (Account) list.get(index);
         a4 = temp.getAcc();
         a ="LogUser(";
       }
       else if(list.get(index) instanceof Manager)
       {
         Manager temp = new Manager();
         temp = (Manager) list.get(index);
         a4 = Integer.toString(temp.getID());
         a ="LogManager(";
       }
         
      String a6 = a + a2 + a3 + a4 + a5;
      try
      {
         FileWriter fw = new FileWriter(a6,true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         
         pw.println(w);
         pw.close();
       }
         
      catch (FileNotFoundException fnfe) {
         System.out.println(fnfe.getMessage());
      } 
      catch (IOException ioe) {
         System.out.println(ioe.getMessage());
      } 
      catch (Exception e) {
         System.out.println(e.getMessage());
    }
 }
    
    public static void Log(ArrayList<Bank> list, int index, int index2, String W, String E)//For Transfer
   {
      Account temp = new Account();//GIVER
      temp = (Account) list.get(index);
      
      Account temp1 = new Account();//RECEIVER
      temp1 = (Account) list.get(index2);
      
      String a = "LogUser(";//GIVER
      String a1 = list.get(index).getName();
      String a2 =",";
      String a3 = temp.getAcc();
      String a4 = ").txt";
      String a5 = a + a1 + a2 + a3 + a4;
      
      String b = "LogUser(";//RECEIVER
      String b1 = list.get(index2).getName();
      String b2 =",";
      String b3 = temp1.getAcc();
      String b4 = ").txt";
      String b5 = b + b1 + b2 + b3 + b4;
      try
      {
         FileWriter fw = new FileWriter(a5,true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         
         FileWriter fw1 = new FileWriter(b5,true);
         BufferedWriter bw1 = new BufferedWriter(fw1);
         PrintWriter pw1 = new PrintWriter(bw1);
         
         pw.println(E);
         pw1.println(W);
         pw.close();
         pw1.close();
       }
         
      catch (FileNotFoundException fnfe) {
         System.out.println(fnfe.getMessage());
      } 
      catch (IOException ioe) {
         System.out.println(ioe.getMessage());
      } 
      catch (Exception e) {
         System.out.println(e.getMessage());
    }

  }
}
