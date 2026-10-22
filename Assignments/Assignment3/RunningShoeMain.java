//Carter Beasley Assignment 3

package Assignment3;

public class RunningShoeMain 
{
    public static void main(String[] args) 
    {
        // Create 4 objects
        RunningShoe shoe1 = new RunningShoe("Nike", "VaporFly");
        RunningShoe shoe2 = new RunningShoe("Adidas", "Adios Pro");
        RunningShoe shoe3 = new RunningShoe("Nike", "Victory 2");
        RunningShoe shoe4 = new RunningShoe("New Balance", "Vongo");

        // Put shoes in an array
        RunningShoe[] myShoes = {shoe1, shoe2, shoe3, shoe4};
        
        // Loop through array and display shoe details
        for (int i = 0; i < myShoes.length; i++) 
        {
            myShoes[i].DisplayInfo();
        }
    }
}