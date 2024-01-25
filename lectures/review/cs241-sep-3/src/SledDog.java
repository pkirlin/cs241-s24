public class SledDog extends Dog {
    private int energy;

    public SledDog(String name, int age, int startingEnergy)
    {
        super(name, age);  // call the (name, age) constructor in Dog
        this.energy = startingEnergy;
    }

    public void pullSled()
    {
        System.out.println(this.getName() + " is the pulling sled");
    }
}
