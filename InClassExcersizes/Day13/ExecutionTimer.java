import java.util.ArrayList;
import java.util.Random;
public class ExecutionTimer {

    public static void main(String[] args) {
        // Start the timing
        long startTime = System.nanoTime();
        
        // The code you want to time
        performSomeOperation();
        
        // End the timing
        long endTime = System.nanoTime();
        
        // Calculate the time taken in milliseconds
        long timeElapsed = (endTime - startTime);
        
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }

    // Create an ArrayList of a bunch of random Integers.
	// Then, search for a bunch of random integers.
	// Record the time (in nanoseconds) to perform the calculation

    private static void performSomeOperation() 
    {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) 
        {
            list.add(rand.nextInt(100));
        }
        for (int i = 0; i < 50; i++) 
        {
            list.contains(rand.nextInt(100));
        }
    }
}
