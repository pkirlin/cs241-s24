public class RArrayList implements RList {

    private int data[];   // where our list elements are stored

    private int size;     // size of the list from the user's perspective

   // private int capacity; // don't need this because we can get the size of the
    // data array with data.length

    // default constructor
    public RArrayList() {
        // we want this constructor to construct an empty array (from the user's perspective)
        data = new int[3];  // allocates memory to hold three elements in our list
        size = 0;  // capacity is 3
    }

    // return a string representing the state of the list from the user's perspective
    public String toString() {
        String answer = "[";
        for (int i = 0; i < size; i++) {
            answer += data[i];
            answer += " ";
        }
        answer += "]";
        return answer;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int get(int pos) {
        return 0;
    }

    @Override
    public void set(int pos, int value) {

    }

    @Override
    public void append(int value) {
        if (size < data.length) {  // we have the capacity to hold more elements
            // update the data array to hold our new value
            data[size] = value;
            // increase the size of the list from the user's perspective
            size++;
        }
        else {
            // we are out of space!
            // we need to make a new array that is bigger than the old data array
            // copy data array into the new array
            // now we have space for the new value
            System.out.println("List is out of space, ignoring new element.");
        }
    }

    @Override
    public void prepend(int value) {

    }
}
