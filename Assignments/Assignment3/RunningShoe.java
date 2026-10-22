//Carter Beasley Assignment 3

package Assignment3;

public class RunningShoe 
{
    // Attributes
    String brand;
    String model;

    // Constructor
    public RunningShoe(String brand, String model) 
    {
        this.brand = brand;
        this.model = model;
    }

    // Display method
    public void DisplayInfo() 
    {
        System.out.println("Shoe details: " + brand + " " + model);
    }
}