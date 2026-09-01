package InClassExcersizes;
import java.util.Scanner;

public class ScannerPractice 
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
    
        System.out.println("Please enter the number of people: ");
        int numPeople = keyboard.nextInt();

        System.out.println("Please enter the total cost of the meal:");
        double mealCost = keyboard.nextDouble();

        double totalCost = mealCost * 1.15;
        double totalPerPerson = totalCost / numPeople;

        System.out.println("With a 15% tip, the total bill is " + totalCost);
        System.out.println("Each person should pay: " + totalPerPerson);

        keyboard.close();

    }
}
