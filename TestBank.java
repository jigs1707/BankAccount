import java.util.Scanner;
import java.util.ArrayList;




public class TestBank
{
public static void main(String[] args)
{
    
 Bank bank = new Bank();
bank.enterCustomers();

System.out.println(); System.out.println("=========================="); System.out.println("Opening account balance"); bank.printBalances();
System.out.println();

bank.banking();
System.out.println(); System.out.println("=========================="); System.out.println("Closing account balance"); bank.printBalances();

}
}





class Bank
{
    
private static ArrayList<Account> accounts = new ArrayList<Account>();


public void enterCustomers(){
   
    String name;
    double balance;
     Scanner sc = new Scanner(System.in);
    
    
    
    System.out.println("Enter customer names or q to quit entering names");
    
    while(true){
        
        System.out.print("Enter a customer name: ");
        name = sc.nextLine();
        
        if(name.equals("q"))
            break;
        
        System.out.print("Enter opening balance: ");
        balance = sc.nextDouble();
       String buffer = sc.nextLine();
        
        accounts.add(new Account(name, balance));
    }
}

public void printBalances()
{
    System.out.printf("%-15s %10s\n", "Customer", "Balance");
    System.out.println("============================");
    
    for(Account a: accounts)
    {
        System.out.printf("%-15s %10s\n", a.getName(), String.format("$%.2f", a.getBalance()));
    }
    System.out.println("============================");
    
}

public String banking()
{
    int select = -1;
    String name;
    double amount;
    
    Scanner sc = new Scanner(System.in);
    
    Account acc;
    
    while (select != 0)
    {
        System.out.print("1. Deposit 2. Withdraw 0. Quit ");
        select = sc.nextInt();
        
        switch(select)
        {
            case 1:
                System.out.print("Customer name: ");
           
                
                name = sc.next();
               
                
                System.out.print("Deposit amount = ");
                amount = sc.nextDouble();
                
                
                acc = findAccount(name);
                
                if(acc == null){
                    System.out.println("No such Customer. Try Again!");
                }
                else{
                    acc.deposit(amount);
                    
                    printBalances();
                }
                break;
                
                
            case 2:
                System.out.print("Customer name: ");
                name = sc.next();
                
                
                
                System.out.print("Withdrawal amount = ");
                amount = sc.nextDouble();
                
                
                acc = findAccount(name);
                
                if(acc == null){
                    System.out.println("Customer not found");
                }
                else {
                    acc.withdraw(amount);
                    
                    printBalances();
                }
                break;
                
                
            case 0: break;
            
            default: System.out.println("Please pick between options 1, 2 and 0");
        }
    }  
    
    return null;
}

 public Account findAccount(String customerName)
{
for(Account acc: accounts)
{
if(acc.getName().equals(customerName))
{
return acc;
}
}
return null;
}

}







class Account
{
    private String name;
    private double balance;
    
    private static Scanner sc = new Scanner (System.in);
    
    public Account(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public void deposit(double deposit)
    {
        
        this.balance = deposit + this.balance;
       
    }
    
    public void withdraw(double withdraw)
    {
  
        if (withdraw <= this.balance){
            this.balance = this.balance - withdraw;
        }
        else{
            System.out.println("Inssufficient balance");
        }
               
    }
}
