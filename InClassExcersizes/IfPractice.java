package InClassExcersizes;
import java.util.Scanner;

public class IfPractice 
{
    public static void main(String[] arg)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many hours of sleep did you get last night? ");
        double sleep = keyboard.nextDouble();

        if (sleep > 8)
        {
            System.out.println("You are well-rested!");
        }
        else if (sleep > 4)
        {
            System.out.println("The coffee shop is around the corner.");
        }
        else if (sleep > 0)
        {
            System.out.println("Are you sure you are awake?");
        }
        else
        {
            System.out.println("Input Error");
        }
        keyboard.close();
    }
}