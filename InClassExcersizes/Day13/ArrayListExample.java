// Create an ArrayList of 3 Strings
// Create an ArrayList of 10 random Integers
// Can you sort each of them? Print out the before and after.

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("String1");
        stringList.add("String2");
        stringList.add("String3");


        ArrayList<Integer> intList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            intList.add(rand.nextInt(100));
        }

        System.out.println("String List Before Sorting: " + stringList);
        Collections.sort(stringList);
        System.out.println("String List After Sorting: " + stringList);

        System.out.println("Integer List Before Sorting: " + intList);
        Collections.sort(intList);
        System.out.println("Integer List After Sorting: " + intList);
    }
  
}
