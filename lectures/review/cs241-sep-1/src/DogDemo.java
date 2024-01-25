public class DogDemo {
    public static void main(String[] args)
    {
        Dog lola = new Dog("Lola", 3);
        Dog perry = new Dog("Perry", 5);
        lola.speak();
        perry.speak();

        // REFERENCES!
        System.out.println("lola's age: " + lola.getAge());
        System.out.println("perry's age: " + perry.getAge());

        lola = perry;  // not a copy operation

        System.out.println("lola's age: " + lola.getAge());
        System.out.println("perry's age: " + perry.getAge());

        perry.setAge(6);

        System.out.println("lola's age: " + lola.getAge());
        System.out.println("perry's age: " + perry.getAge());

        lola.setAge(10);

        System.out.println("lola's age: " + lola.getAge());
        System.out.println("perry's age: " + perry.getAge());

        lola = new Dog("lola 2.0", 3);
        System.out.println("lola's age: " + lola.getAge());
        System.out.println("perry's age: " + perry.getAge());

        int x = 5;
        int y = 10;
        System.out.println(x + " " + y);
        x = y;
        System.out.println(x + " " + y);
        x += 1;
        System.out.println(x + " " + y);

        String a = "alice";
        String b = "bob";
        System.out.println(a + " " + b);
        a = b;
        System.out.println(a + " " + b);
        a = new String("alice");
        System.out.println(a + " " + b);

    }
}
