package Assignment1;

public class Runner {
    String name;
    int age;
    double mileage;

    // Constructor to initialize the object's data
    public Runner(String name, int age, double mileage) {
        this.name = name;
        this.age = age;
        this.mileage = mileage;
    }

    // Behavior method
    public void introduce() {
        System.out.println("Name: " + name + ", Age: " + age + ", Mileage this week: " + mileage + " miles.");
    }
}