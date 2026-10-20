import java.util.HashMap;
import java.util.Scanner;

public class HashPractice {
    public static void main(String[] args) 
    {
        HashMap<Integer, String> passwords = new HashMap<Integer, String>();
        passwords.put(101, "password123");
        passwords.put(102, "IHeartCS");
        passwords.put(103, "password123");
        System.out.println(passwords);

        System.out.println(passwords.get(102));

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your ID: ");
        int targetID = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Enter your Password: ");
        String targetPassword = keyboard.nextLine();

        if (passwords.containsKey(targetID) && passwords.get(targetID).equals(String.valueOf(targetPassword)))
        {
            System.out.println("Access Granted!");
        }
        else
        {
            System.out.println("Access Denied!");   
        }
        
        keyboard.close();

    }
}