1. What I Learned from the Reading

The article shows how polymorphism reduces code maintenance. By programming to the parent class (Vehicle), the Driver class doesn't need separate driveCar() or driveBike() methods.
It illustrates the scalability of polymorphism. The article shows that when a brand new Train class is created, the Driver class doesn't require a single line of code to be updated. This helped me understand how polymorphism allows a single variable (Vehicle) to take on many different forms (Car, Bike, Train).

2. What You Changed

I added a console-based user interface to allow users to view all instruments, play an instrument, add a new piano or guitar, and exit the program. I also added play() functionality to the instrument classes. Users can play an instrument normally or specify a playing duration. The program validates numeric input and accepts decimal costs when adding instruments.

3. Method Overloading and Method Overriding

Method Overloading
Method overloading was used in the Instrument class with play() and play(int durationSeconds). Both methods have the same name but different parameter lists. This works because users can either play an instrument using the default behavior or specify how many seconds it should play.

Method Overriding
Method overriding was used in the Piano and Guitar classes. Both classes override play() and play(int durationSeconds). The subclasses provide behavior specific to each instrument. For example, a piano plays a melody while a guitar plays a chord. The toString() method is also overridden in both Piano and Guitar so that the output includes each instrument’s type.

4. Challenges Encountered

One challenge was integrating the new menu with the existing inheritance structure while preserving the original instrument list and polymorphic behavior. I also had problems with Google Antigravity because it would generate code and then it would just disappear. I have no clue why so I ended up switching to 

5. Use of AI tools

Github Copilot was used to add user interface and play() functionality

Google Antigravity was used for the same thing but ended up not working for some reason.