public class Dog implements Pet {
    private String name;
    private int age;

    public Dog(String newName)
    {
        this.name = newName;
    }

    public void setAge(int newAge)
    {
        if (newAge >= 0)
        {
            this.age = newAge;
        }
    }

    public String getName()
    {
        return name;
    }

    public void speak()
    {
        System.out.println(name + " says woof woof and age is " + age);
    }
}
