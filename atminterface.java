import java.util.Scanner;

class BankAccount 
{
    int Balance;
    int prev_transaction;
    String Customer_name;
    String Customer_id;
    int flag = 0;

    BankAccount(String cname, String cid) 
    {
        Customer_name = cname;
        Customer_id = cid;
    }

    public final void clrscr() 
    {
        try 
        {
            try 
            {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) 
            {
                Runtime.getRuntime();
            } 
            else 
            {
                Runtime.getRuntime();
            }
        } 
        catch (final Exception e) 
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } 
    catch (final Exception es) 
    {
        System.out.println("Nothing !!!");
    }

    }

    void checkID() 
    {
        clrscr();
        Scanner id = new Scanner(System.in);
        System.out.println("Welcome " + Customer_name);
        System.out.println();
        System.out.print("Please enter the ATM PIN: ");
        String check = id.nextLine();
        if (check.equals(Customer_id)) 
        {
            clrscr();
            showMenu();
        } 
        else 
        {
            System.out.println("Entered Wrong ID or pin !!!");

            if (flag < 3) 
            {
                flag++;
                checkID();
            }
        }
    }

    void deposit(int amount) 
    {
        if (amount != 0) 
        {
            Balance = Balance + amount;
            prev_transaction = amount;
        }
    }

    void withdraw(int amount) 
    {
        if (this.Balance > amount) 
        {
            Balance = Balance - amount;
            prev_transaction = -amount;
        }
        else 
        {
            clrscr();
            System.out.println("Insufficient Balance to perform withdrawal!");
        }
    }

    void getPrev_transaction() 
    {
        if (prev_transaction > 0) 
        {
            System.out.println("------Deposited: " + prev_transaction+"------");
        } 
        else if (prev_transaction < 0) 
        {
            System.out.println("------Withdraw: " + Math.abs(prev_transaction)+"------");
        } 
        else 
        {
            System.out.println("No Transaction");
        }
    }

    public void transfer(double amount, BankAccount acc) 
    {
        if (this.Balance < amount) 
        {
            clrscr();
            System.out.println("Transfer Fails due to insufficient balance!");
        } 
        else 
        {
            this.Balance -= amount;
            acc.Balance += amount;
            System.out.println("Account of " + this.Customer_name + " becomes " + this.Balance);
            System.out.println("Account of " + acc.Customer_name + " becomes " + acc.Balance);
            System.out.println("\n");
        }
    }

    private void showMenu() 
    {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + Customer_name);
        System.out.println("Your ID is  " + Customer_id);
        do 
        {
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Exit");

            System.out.println("Enter an option");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    clrscr();
                    System.out.println("-------Balance " + Balance+"------");
                    System.out.println("\n");
                    break;

                case 'B':
                    clrscr();
                    System.out.println("Enter the amount to deposit");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                
                case 'C':
                    clrscr();
                    System.out.println("Enter the amount to withdraw");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    clrscr();
                    getPrev_transaction();
                    System.out.println("\n");
                    break;

                case 'E':
                    clrscr();
                    System.out.println("To ");
                    BankAccount bb = new BankAccount("Jason", "6636");
                    System.out.println(bb.Customer_name);
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    transfer(am, bb);
                    break;

                case 'F':
                    clrscr();
                    break;
                
                default:
                    clrscr();
                    System.out.println("Invalid Option!!! Please Try Again");
            }

        } 
        while (option != 'F');
        System.out.println("ThankYou For using our services");

    }
}

public class atminterface 
{
    public static void main(String[] args) 
    {
        BankAccount ba = new BankAccount("shyum","6644");
        ba.checkID();
    }

}