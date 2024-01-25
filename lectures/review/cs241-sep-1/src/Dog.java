public class Dog {
    private int age;
    final private String name;

    // default constructor - has no arguments
    public Dog()
    {
        age = 0;
        name = "Dog";
    }

    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age)
    {
        if (age >= 0)
            this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void speak()
    {
        System.out.println(this.name + " says woof woof");
    }

    public void eat()
    {
        System.out.println(this.name + " is eating.");
    }
}
