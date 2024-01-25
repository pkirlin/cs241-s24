

public class Cat extends Pet {

    // default constructor - has no arguments
    public Cat()
    {
        //age = 0;
        //name = "Dog";
        super("Cat", 0);
    }

    public Cat(String name, int age)
    {
        super(name, age);
    }


    public void speak()
    {
        System.out.println(this.getName() + " says meow");
    }

}
