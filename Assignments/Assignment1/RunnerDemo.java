package Assignment1;

import java.util.Scanner; // Bring in the Scanner tool

public class RunnerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Add a New Runner ---");
        
        // Ask the user for the runner's details
        System.out.print("Enter runner's name: ");
        String newName = scanner.nextLine();
        
        System.out.print("Enter runner's age: ");
        int newAge = scanner.nextInt(); 
        
        System.out.print("Enter weekly mileage: ");
        double newMileage = scanner.nextDouble(); 
        
        // Create a new Runner object using the input variables
        Runner customRunner = new Runner(newName, newAge, newMileage);
        
        // Print Runner's information
        System.out.println("\nRunner successfully created! Here is their info:");
        customRunner.introduce();
        
        scanner.close();
    }
}

// Resource: Gemini
// Asked for an explanation on how to request input and why I can't do it in one line like in Python.