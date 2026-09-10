package InClassExcersizes;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class RandomNumberPractice 
{
    public static void main(String[] args) throws IOException
    {
        PrintWriter outputFile = new PrintWriter("RandomNumbers.txt");
        
        for (int i = 0; i < 2yes; i++)
        {
            Random rand = new Random();
            int randomNum = rand.nextInt(100) + 1;
            System.out.println("Random number: " + randomNum);
            outputFile.println(randomNum);
        }
        outputFile.close();
        System.out.println("Number written to file.");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to read the file? (yes/no)");
        String response = keyboard.nextLine();
        keyboard.close();
        //Find the average of the numbers added to file
        if (response.equals("yes"))
        {
            File myFile = new File("RandomNumbers.txt");
            Scanner inputFile = new Scanner(myFile);

            
            double count = 0;
            double total = 0;
            while (inputFile.hasNext())
            {
                int num = inputFile.nextInt();
                count += 1;
                total += num;
            }
            inputFile.close();
            System.out.println("The average of the numbers in the file is: " + (total / count));

        }
        else
        {
            System.out.println("Okay!");
        }
    }
}
