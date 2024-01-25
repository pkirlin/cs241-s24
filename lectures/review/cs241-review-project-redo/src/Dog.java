public class Dog implements Pet
{
    // State to represent: name, age.
    private String name;
    private int age;

    public Dog(String newName)
    {
        this.name = newName;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int newAge)
    {
        if (newAge >= 0) {
            this.age = newAge;
        }
    }

    public void speak()
    {
        System.out.println(this.getName() + " is barking.");
    }

    public String toString()
    {
        return "This dog's name is " + this.name + " and the age is " + this.age;
    }
}
