import java.util.*;


public class NumberGuessingGame
{
static ArrayList<Integer> ScoreBoard=new ArrayList<Integer>();
public static void main(String[] args)
{
    NumberGuessingGame methodChange=new NumberGuessingGame();
    methodChange.menu(ScoreBoard);
}


public void menu(ArrayList<Integer> ScoreBoard)
{
NumberGuessingGame methodChange = new NumberGuessingGame();
Scanner sc=new Scanner(System.in);
System.out.println("Welcome to -------NUMBER GUESSING GAME-----");
System.out.println("< Game MENU >");
System.out.println("1.Play the game\n2.ScoreBoard\n3.EXIT");
try
{
    System.out.println("Enter your option from the above menu! :");
    int menuOption=sc.nextInt();
    switch(menuOption)
    {
        case 1: System.out.println("Enter the size of the Number Range :");
                int numberRange=sc.nextInt();
                int randomNumber=methodChange.randomNumber(numberRange);
                methodChange.guessNumber(randomNumber);
                break;

        case 2: methodChange.DisplayScoreBoard();
                break;

        case 3: System.out.println("\n"+"--------Thank You for playing the Game!--------");
                System.exit(1);
                break;

        default: throw new InputMismatchException("Invalid Option!!! Please try again Later!!!");                        
    }
}
catch(InputMismatchException e)
{
    System.err.println("\n"+e.getMessage()+"\n");
    menu(ScoreBoard);
}
}


public int randomNumber(int numberRange)
{
Random random=new Random();
int randomNumber=random.nextInt(numberRange) + 1;
return randomNumber;
}


public void guessNumber(int randomNumber)
{
    Scanner sc=new Scanner(System.in);
    int guess_count=0;
    int userGuess;
    do
    {
    System.out.println("Guess the Number! :");
    userGuess=sc.nextInt();
    guess_count++;
    if(userGuess > randomNumber)
    {
        System.out.println("-----Lower Than "+userGuess+"-----");
    }
    else if(userGuess < randomNumber)
    {
        System.out.println("-----Higher Than "+userGuess+"-----");
    }
    }
    while(userGuess != randomNumber);
    System.out.println(" ");
    if(guess_count == 1)
    {
        System.out.println("You Guessed the Number in "+guess_count+" try!");
    }
    else
    {
        System.out.println("You Guessed The Number in "+guess_count+" tries!");
    }
    ScoreBoard.add(guess_count);
    System.out.println(" ");
    menu(ScoreBoard);
}


public void DisplayScoreBoard()
{
    System.out.println("----ScoreBoard-----");
    System.out.println("Your fastest games today out of all tries is :"+"\n");
    Collections.sort(ScoreBoard);
    for(Integer score : ScoreBoard)
    {
        System.out.println("Finished the NumberGuessingGame in "+score+" tries!");
    }
    System.out.println(" ");
    menu(ScoreBoard);
}
}