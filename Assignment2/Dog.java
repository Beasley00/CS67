public class Dog 
{
    String name;
    int age;

    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void introduce() 
    {
        System.out.println("Name: " + name + ", Age: " + age + " years.");
    }
}
