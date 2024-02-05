import java.util.*;

import static java.awt.event.MouseEvent.BUTTON1;

public class Reservation{                                                                         

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" WELCOME TO ONLINE RESERVATION SYSTEM");
        System.out.println("\t\t\t\tSelect an Option\t\t\t");
        System.out.println("\t\t1. SIGN UP \t\t\t\t\t 2. LOGIN");
        int Option;
        Option = sc.nextInt();
        switch (Option)
        {
            case 1: 
            {
                SIGNIN();
                break;
            }
            case 2: 
            {    
                System.out.println("First Create an Account!!!");
                SIGNIN();
                break;
            }
            default:
            {    
                System.out.println("\t\t\tINCORRECT INPUT\t\t\t\t");
            }
        }
    }

    public static void SIGNIN() 
    {
        Scanner sc = new Scanner(System.in);
        String id = "";
        String pwd = "";
        System.out.print("Enter User ID : ");
        try 
        {
        id = sc.next();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.print("Enter password : ");
        try 
        {
            pwd = sc.next();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.println("|-----------------SIGN IN SUCCESSFULLY---------------------|");
        System.out.println("|----------------------------------------------------------|");
        LOGIN(id, pwd);
    }

    public static void LOGIN(String id, String pwd) 
    {
        String L_id;
        String L_pwd;
        int BUTTON1 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\tLOGIN WINDOW\t\t\t\t");
        System.out.print("Enter User Login ID : ");
        L_id = sc.next();
        System.out.print("Enter Login password : ");
        L_pwd = sc.next();
        if (id.equals(L_id)) 
        {
            if (pwd.equals(L_pwd)) 
            {
                System.out.println("|-------------------LOGIN IN SUCCESSFULLY------------------|");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("\t\tPRESS BELOW BUTTON");
                System.out.println("1.Reservation System");
                try 
                {
                    BUTTON1 = sc.nextInt();
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }
                if (BUTTON1 == 1) 
                {
                    ReservationSystem();
                } 
                else 
                {
                    System.out.println("\t\t\tINCORRECT INPUT\t\t\t\t ");
                }
            } 
            else 
            {
                System.out.println("\t\t\t\tINCORRECT ID & PASSWORD\t\t\t");
                LOGIN(id, pwd);
                System.exit(0);
            }
        } 
        else 
        {
            System.out.println("\t\t\t\tINCORRECT ID & PASSWORD\t\t\t");
            LOGIN(id, pwd);
            System.exit(0);
        }
    }

    public static void CancellationSystem(String name, int age, String start, String end, int PNR, int Class_Type, String date, String train_name, int Train_Number) 
    {
        Scanner C = new Scanner(System.in);
        System.out.println("-------------If you want to cancel the Ticket!!!-------------");
        System.out.println("------>Fill the Below Details");
        System.out.print("Enter PNR : ");
        int PNR_No = 0;
        try 
        {
            PNR_No = C.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        if (PNR == PNR_No) 
        {
            ticket(name, age, start, end, PNR, Class_Type, date, train_name, Train_Number);
            System.out.println("|-------------------CANCELLATION SUCCESSFULLY--------------|");
            System.out.println("|----------------------------------------------------------|");
        } 
        else 
        {
            System.out.println("PNR NOT FOUND");
            CancellationSystem(name, age, start, end, PNR, Class_Type, date, train_name, Train_Number);
        }
    }

    public static void ReservationSystem() 
    {
        String name = "";
        int age = 0;
        String start = "";
        String end = "";
        int Class_Type = 0;
        String date = "";
        String train_name = "";
        Scanner R = new Scanner(System.in);
        System.out.println("\t\tEnter the Required Details");
        System.out.print("Enter Name of Passenger : ");
        try 
        {
            name = R.nextLine();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.print("Enter age : ");
        try 
        {
        age = R.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        R.nextLine();
        System.out.print("Enter Train Name : ");
        try 
        {
            train_name = R.nextLine();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.print("Enter Destination Date : ");
        try 
        {
            date = R.next();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.print("Enter Class Type : ");
        try 
        {
            Class_Type = R.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.print("Enter Destination\nFrom: ");
        try 
        {
            start = R.next();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        System.out.print("To ");
        try 
        {
            end = R.next();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        int Train_Number = (int) (Math.random() * 1000000);
        int PNR = (int) (Math.random() * 10000);
        System.out.print("--->Press 1 To Generate Ticket : ");
        try 
        {
            int BUTTON1 = R.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(0);
        }
        if (BUTTON1 == 1) 
        {
            ticket(name, age, start, end, PNR, Class_Type, date, train_name, Train_Number);
        } 
        else 
        {
            System.out.println("\t\t\tINCORRECT INPUT\t\t\t\t");
        }
        System.out.println("--------PRESS A BUTTON FROM BELOW----------");
        System.out.println("1.Ticket Confirm\t\t\t2.Cancel Tickets");
        int button3 = R.nextInt();
        switch (button3) 
        {
            case 1:
            {
                ticket(name, age, start, end, PNR, Class_Type, date, train_name, Train_Number);
                System.out.println("|----------YOUR TICKET IS CONFIRMED SUCCESSFULLY-----------|");
                System.out.println("|----------------------------------------------------------|");
            
            }
            case 2:
            {    
                CancellationSystem(name, age, start, end, PNR, Class_Type, date, train_name, Train_Number);
                break;
            }
            default:
            {    
                System.out.println("\t\t\tINCORRECT INPUT\t\t\t\t");
                break;
            }
        }

    }

    public static void ticket(String name, int age, String start, String end, int PNR, int Class_Type, String date, String train_name, int Train_Number) 
    {
        Scanner T = new Scanner(System.in);
        System.out.println("\t\t\t\tTICKET\t\t\t\t");
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("\t\t\t\t\t\t\t\t" + new Date());
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|Train Name|\t\t\t|Train Number|\t\t\t|PNR|\t\t\t|Class_Type|");
        System.out.println( train_name + "\t\t\t\t\t" + Train_Number + "\t\t\t" + PNR + "\t\t\t\t" + Class_Type);
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("\nDestination - " + start + "\t\tTo\t\t" + end);
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("\n|Passenger Name|\t\t\t|Age|\t\t\t|Date|");
        System.out.println(  name + "\t\t\t\t\t" + age + "\t\t\t" + date);
        System.out.println("|--------------------------------------------------------------------------------------|");
    }

    public void Cancelticket(String name, int age, String start, String end, int PNR, int Class_Type, String date, String train_name, int Train_Number) 
    {
        Scanner CT = new Scanner(System.in);
        System.out.println("----------------IF YOU WANT TO CANCEL TICKET!!!----------------");
        System.out.print("PRESS BUTTON 1 : ");
        int BUTTON2 = CT.nextInt();
        if (BUTTON2 == 1) 
        {
            CancellationSystem(name, age, start, end, PNR, Class_Type, date, train_name, Train_Number);
        } 
        else 
        {
            System.out.println("\t\t\tINCORRECT INPUT\t\t\t\t")
        }
    }
}