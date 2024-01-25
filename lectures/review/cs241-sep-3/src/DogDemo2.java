import java.util.ArrayList;

public class DogDemo2 {
    public static void main(String[] args) {
        Dog lassie = new Dog("Lassie", 3);
        Dog toto = new Dog("Toto", 4);
        Dog marley = new Dog("Marley", 5);

        System.out.println(lassie.getAge() + " " +  toto.getAge() + " " + marley.getAge());

        lassie.setAge(6);
        toto = lassie;
        System.out.println(lassie.getAge() + " " +  toto.getAge() + " " + marley.getAge());

        toto = new Dog("New Toto", 7);
        lassie = toto;
        lassie.setAge(8);
        marley.setAge(9);
        Dog barkley = marley;
        marley = lassie;
        System.out.println(lassie.getAge() + " " +  toto.getAge() + " " + marley.getAge() + " " + barkley.getAge());

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Lucky", 3));
        dogs.add(new Dog("Rolly", 4));
        dogs.add(new Dog("Penny", 5));
        dogs.add(new Dog("Freckles", 6));
        Dog anotherdog = dogs.get(0);
        dogs.set(0, dogs.get(1));
        dogs.get(0).setAge(7);
        dogs.set(1, dogs.get(2));
        dogs.set(2, new Dog("Pepper", 8));
        anotherdog.setAge(9);
        dogs.set(3, anotherdog);

        System.out.println(
                dogs.get(0).getAge() + " "
                + dogs.get(1).getAge() + " "
                + dogs.get(2).getAge() + " "
                + dogs.get(3).getAge());
    }
}
