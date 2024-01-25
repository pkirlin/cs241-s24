import java.util.Objects;

public class Dog extends Pet {

    // default constructor - has no arguments
    public Dog()
    {
        //age = 0;
        //name = "Dog";
        super("Dog", 0);
    }

    public Dog(String name, int age)
    {
        super(name, age);
    }


    public void speak()
    {
        System.out.println(this.getName() + " says woof woof");
    }

}
