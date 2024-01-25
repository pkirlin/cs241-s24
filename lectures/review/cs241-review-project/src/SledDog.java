public class SledDog extends Dog
{
    private int energy;

    public SledDog(String newName)
    {
        super(newName); // call the superclass's (Dog's) constructor
    }

    public void pullSled()
    {
        System.out.println(getName() + " is pulling the sled.");
    }

    public void speak()
    {
        System.out.println(getName() + " is speaking however a sled dog speaks.");
    }
}
