import java.util.Arrays;

public class RArrayList implements RList {

    private int[] data;  // this is where we store the elements of the array
    private int size;    // this is the size of the array from the user's perspective
    //private int capacity  // not needed because in java we can use data.length

    public RArrayList() {  // default constructor
        // We need to reserve some capacity in our data array for new elements to be added.
        data = new int[3];  // reserves 3 spots in the data array  for us to use
        size = 0;
    }

    public String toString() {
        // should only print the number of integers that the user can see!
        String answer = "[";
        for (int i = 0; i < size; i++) {
            answer += data[i];
            answer += " ";
        }
        //return Arrays.toString(data);
        return answer + "]";
    }

    @Override
    public int size() { // return size of RArrayList from the user's perspective
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
    public void append(int value) {  // append should add an element to the end of the list

        // check to see if there is space in the data array for our new value
        if (size < data.length) {  // size < capacity
            data[size] = value;
            size++;
        }
        else {
            // expand the array to make more empty slots
            expand();
            // add our new value into the next available empty slot
            data[size] = value;
            size++;
        }
    }

    @Override
    public void prepend(int value) {  // adds an element to beginning of the list (always index 0)
        // check to see if there is space in the data array for our new value
        if (size == data.length) {  // size == capacity --> out of room
            expand();
        }
        // once we get here, we know we have room for our new element
        // shift each element one spot to the right
        for (int i = size-1; i >= 0; i--) {   // orig: i = 0; i < size
            data[i + 1] = data[i];
        }
        // add our new element to index 0
        data[0] = value;
        size++;
    }

    // Expand will make a new array of a bigger size than the existing one,
    // copy everything from the old array into the new array
    private void expand() {
        //System.out.println("Expanding from capacity " + data.length + " to " + (data.length+3));
        int[] newdata = new int[data.length + 3]; // make array of same size as old one, plus 3 more spots
        // copy everything from data -> newdata
        for (int i = 0; i < data.length; i++) {
            newdata[i] = data[i];
        }
        data = newdata;

    }
}
