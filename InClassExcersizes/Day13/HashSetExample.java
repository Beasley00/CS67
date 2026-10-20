import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {
        HashSet<String> groceriesHashSet = new HashSet<String>();

        groceriesHashSet.add("milk");
        groceriesHashSet.add("eggs");
        groceriesHashSet.add("bread");
        groceriesHashSet.add("bread");
        
        System.out.println(groceriesHashSet);
        if (groceriesHashSet.contains("milk")) {
            System.out.println("We have milk!");
        }

        if (groceriesHashSet.contains("grapes")) {
            System.out.println("We have grapes!");
        }
        else {
            System.out.println("We don't have grapes. :(");
        }
    }
}
