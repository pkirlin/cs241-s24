public abstract class Pet {
    private int age;
    final private String name;

    // default constructor - has no arguments
    public Pet()
    {
        age = 0;
        name = "Pet";
    }

    public Pet(String name, int age)
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

    public String getName()
    {
        return name;
    }

    public abstract void speak();

    public void eat()
    {
        System.out.println(this.name + " is eating.");
    }
}
