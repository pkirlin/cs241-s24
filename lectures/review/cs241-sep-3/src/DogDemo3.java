import java.util.ArrayList;

public class DogDemo3 {
    public static void main(String[] args) {
        Dog d1 = new Dog("Fluffy", 3);
        Dog d2 = new Dog("Lila", 4);
        Dog d3 = new Dog("Daisy", 5);
        Dog d4 = d3;

        System.out.println(d1.getAge() + " " +  d2.getAge() + " " + d3.getAge() + " " + d4.getAge());

        d2.setAge(6);
        d4.setAge(7);
        d3.setAge(8);
        d4 = d1;
        d1.setAge(9);
        d4 = new Dog("Loki", 10);

        System.out.println(d1.getAge() + " " +  d2.getAge() + " " + d3.getAge() + " " + d4.getAge());

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Ginger", 3));
        dogs.add(new Dog("Buster", 4));
        dogs.add(new Dog("Lucky", 5));
        dogs.add(new Dog("Rocky", 6));
        Dog anotherdog = dogs.get(3);
        dogs.set(3, dogs.get(1)); // dogs[3] = dogs[1]
        dogs.set(2, anotherdog);  // dogs[2] = anotherdog
        dogs.get(2).setAge(7);
        anotherdog = dogs.get(0);
        anotherdog.setAge(8);
        dogs.get(0).setAge(dogs.get(0).getAge() + 1);

        System.out.println(
                dogs.get(0).getAge() + " "
                + dogs.get(1).getAge() + " "
                + dogs.get(2).getAge() + " "
                + dogs.get(3).getAge() + " "
                + anotherdog.getAge());
    }
}
