import java.util.Scanner;
public class DogMain {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
    
        // Dog 1
        System.out.print("Enter your dogs name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter your dogs age: ");
        int age = keyboard.nextInt();

        Dog dog1 = new Dog(name, age);

        keyboard.nextLine(); // Consume the leftover newline character

        // Dog 2
        System.out.print("Enter your dogs name: ");
        String name2 = keyboard.nextLine();

        System.out.print("Enter your dogs age: ");
        int age2 = keyboard.nextInt();

        Dog dog2 = new Dog(name2, age2);

        dog1.introduce();
        dog2.introduce();

        keyboard.close();

    }
}
