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
        return size;
    }

    @Override
    public int get(int pos) {
        return data[pos];
    }

    @Override
    public void set(int pos, int value) {
        data[pos] = value;
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
            expand();
            data[size] = value;
            // increase the size of the list from the user's perspective
            size++;
        }
    }

    @Override
    public void prepend(int value) {
        if (size == data.length) { // true when we need to expand the array
            expand();
        }
        // now we know we have enough room for the new element
        for (int i = size-1; i >= 0; i--) {  ///for (int i = 0; i < size; i++) {
            data[i + 1] = data[i];
        }
        // put new element at beginning
        data[0] = value;
        size++;
    }

    // Expand will copy all the data in the data[] array into a new array of
    // a larger size.
    private void expand() {
        System.out.println("Expanding from capacity " + data.length + " to new capacity " + (data.length+3));
        int[] newdata = new int[data.length + 3];   // makes space for same size as old data, plus 3 more spots
        // copy all of the data into newdata
        for (int i = 0; i < data.length; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }
}
