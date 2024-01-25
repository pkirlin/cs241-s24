import java.util.ArrayList;

public class DogTest
{
    public static void main(String[] args)
    {
        Dog dog1 = new Dog("Fido");
        dog1.setAge(3);

        Dog dog2 = new Dog("Lassie");
        dog2.setAge(4);

        SledDog dog3 = new SledDog("Rufus");
        dog3.setAge(6);

        /*System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);*/

        dog3.pullSled();

        ArrayList<Pet> mypets = new ArrayList<Pet>();
        mypets.add(dog1);
        mypets.add(dog2);
        mypets.add(dog3);
        mypets.add(new Cat());

        System.out.println("Here are my pets:");
        for (Pet pet : mypets)
        {
            System.out.println(pet);
            pet.speak();

            if (pet instanceof SledDog)
            {
                ((SledDog)pet).pullSled();
            }
        }
    }
}
