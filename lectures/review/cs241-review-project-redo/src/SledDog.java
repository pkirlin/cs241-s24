public class SledDog extends Dog
{
    public SledDog(String newName)
    {
        super(newName); // call the superclass's constructor, passing in newName
    }

    public void pullSled()
    {
        System.out.println(this.getName() + " is pulling the sled.");
    }

    public void speak()
    {
        System.out.println(this.getName() + " is barking like a sleddog barks.");
    }
}
