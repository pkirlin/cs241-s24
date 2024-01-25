import java.util.ArrayList;

public class DogDemo {
    public static void main(String[] args)
    {
        Dog lola = new Dog("Lola", 3);
        Dog perry = new Dog("Perry", 5);
        lola.speak();
        perry.speak();

        SledDog balto = new SledDog("Balto", 5, 100);
        balto.speak();

        Cat karbon = new Cat("Karbon", 6);
        karbon.speak();

        ArrayList<Pet> mypets = new ArrayList<Pet>();
        mypets.add(karbon);
        mypets.add(lola);
        mypets.add(perry);
        mypets.add(balto);

        mypets.get(2).speak();
    }
}
