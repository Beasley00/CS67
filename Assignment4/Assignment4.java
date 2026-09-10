//Carter Beasley
//Decoded Message 1: EatMoreVegetables
//Decoded Message 2: FourCharsAfterW
//Decoded Message 3: tinyurl.com/3s847myv
package Assignment4;

import java.io.*;
import java.util.Scanner;

public class Assignment4 
{
    public static void main(String[] args) throws IOException
    {

        File secretFile = new File("Assignment4", "Assignment4Input.txt");

        //Secret Message #1
        //Find every occurrence of a capital X.
        //Extract the 3rd character after each capital X.
        System.out.println("Decoding Message 1:");
        Scanner scanCode1 = new Scanner(secretFile);
        for (int i = 0; i < 20; i++)
        {
            String str = scanCode1.nextLine();
            for (int j = 0; j < str.length(); j++)
            {
                if (str.charAt(j) == 'X')
                {
                    System.out.print(str.charAt(j + 3));
                }
            }
        }
        scanCode1.close();
        System.out.println("");

        //Secret Message #2
        //Find every occurrence of a capital Y.
        //Extract the 5th character after each capital Y.
        System.out.println("Decoding Message 2:");
        Scanner scanCode2 = new Scanner(secretFile);
        for (int i = 0; i < 20; i++)
        {
            String str = scanCode2.nextLine();
            for (int j = 0; j < str.length(); j++)
            {
                if (str.charAt(j) == 'Y')
                {
                    System.out.print(str.charAt(j + 5));
                }
            }
        }
        scanCode2.close();
        System.out.println("");

        //Secret Message #3
        //Find every occurrence of a capital W.
        //Extract the 4th character after each capital W.
        System.out.println("Decoding Message 3:");
        Scanner scanCode3 = new Scanner(secretFile);
        for (int i = 0; i < 20; i++)
        {
            String str = scanCode3.nextLine();
            for (int j = 0; j < str.length(); j++)
            {
                if (str.charAt(j) == 'W')
                {
                    System.out.print(str.charAt(j + 4));
                }
            }
        }
        scanCode1.close();
        System.out.println("");

    }
}
