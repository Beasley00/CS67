package InClassExcersizes;

public class FunctionPractice 
{
    public static int countChar(String str, char targetChar) 
    {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) 
        {
            if (str.charAt(i) == targetChar) 
            {
                counter++;
            }
        }
        
        return counter;
    }

    public static void main(String[] args) 
    {
        
        int numChar = countChar("Hello World", 'l');
        System.out.println("Number of occurrences: " + numChar);

    }
}
