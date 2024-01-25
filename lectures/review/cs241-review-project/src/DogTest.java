import java.util.ArrayList;

public class DogTest {
    public static void main(String[] args)
    {
        Dog fido = new Dog("Fido");
        Dog fluffy = new Dog("Fluffy");
        fido.setAge(3);
        fluffy.setAge(4);

        /*fido.speak();
        fluffy.speak();

        Dog fidoBackup = fido;

        fido = fluffy;

        fido.speak();
        fluffy.speak();

        fluffy.setAge(5);

        fido.speak();
        fluffy.speak();

        fidoBackup.speak();*/
        SledDog rufus = new SledDog("Rufus");
        rufus.setAge(5);
        //rufus.speak();
        rufus.speak();
        rufus.pullSled();

        ArrayList<SledDog> mydogs = new ArrayList<SledDog>();
        //mydogs.add(fido);
        //mydogs.add(fluffy);
        mydogs.add(rufus);

        System.out.println("All dogs will speak:");

        for (SledDog dog : mydogs)
        {
            dog.pullSled();
        }
    }
}
