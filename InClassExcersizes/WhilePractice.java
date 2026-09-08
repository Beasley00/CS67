package InClassExcersizes;
import java.util.Scanner;

public class WhilePractice 
{
    public static void main(String[] arg)
    {
        Scanner keyboard = new Scanner(System.in);

        int number = 0;
        int counter = 2;
        int infinite = 1;

        while (number != 7)
        {
            System.out.println("Please enter a number 1-10: ");
            number = keyboard.nextInt();
        }
        
        while (counter < 1025)
        {
            System.out.print(counter);
            System.out.println(" ");
            counter += 2;
        }

        while (infinite >0)
        {
            System.out.println("InfiniteLoop   ");
            counter++;
        }

    }
}