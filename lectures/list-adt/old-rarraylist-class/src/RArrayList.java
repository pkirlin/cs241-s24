import java.util.Arrays;

public class RArrayList implements RList
{
    private int size; // the number of elements in the list from the user's perspective
    private int[] data;  // the array that holds our elements
    //private int capacity;
    // data.length will substitute for int capacity

    public RArrayList()
    {
        // from the user's perspective, we should create an empty list
        size = 0;
        data = new int[3];  // allocates three "starter elements" for us
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int pos) {
        // Assumes pos is a valid index.
        return data[pos];
    }

    @Override
    public void set(int pos, int value) {
        // Assumes pos is a valid index.
        data[pos] = value;
    }

    @Override
    public void append(int value) {
        // figure out if we need to expand
        if (size == data.length)
        {
            expand();
        }

        // how do figure out what index/position the value should go into?
        data[size] = value;
        size++;
    }

    @Override
    public void prepend(int value) {
        if (size == data.length)  // array is full
        {
            expand();
        }

        for (int x = size; x > 0; x--) // shift all ints one spot to the right
        {
            data[x] = data[x - 1];
        }

        data[0] = value;
        size++;
    }

    public String toString() // used for displaying the class from the user's perspective
    {
        String answer = "[";
        for (int x = 0; x < size; x++)
        {
            answer += (data[x] + " ");
        }
        return answer + "]";
    }

    public String toInternalString() // displays the class from the programmer's perspective
    {
        String answer = "";
        answer += Arrays.toString(data);
        answer += " ";
        answer += "capacity = " + data.length;
        return answer;
    }

    // Allocate more memory for our data, but we don't change
    // the size from the user's perspective.
    private void expand()
    {
        int newlength = data.length + 3;
        int[] newdata = new int[newlength];

        // copy over everything from data -> newdata
        for (int x = 0; x < size; x++)
        {
            newdata[x] = data[x];
        }
        data = newdata;
    }
}
