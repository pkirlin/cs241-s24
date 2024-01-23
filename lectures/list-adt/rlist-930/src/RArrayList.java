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
    public void append(int value) {  // append should add an element to the end of the list

        // check to see if there is space in the data array for our new value
        if (size < data.length) {
            data[size] = value;
            size++;
        }
        else {
            // expand the array to make more empty slots
            // add our new value into the next available empty slot
        }
    }

    @Override
    public void prepend(int value) {

    }
}
