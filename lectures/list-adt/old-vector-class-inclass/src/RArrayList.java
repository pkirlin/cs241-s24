import java.util.Arrays;

public class RArrayList implements RList
{
    private int[] data;
    private int size;
    //int capacity - we will use data.length instead.

    public RArrayList()
    {
        size = 0;
        data = new int[3];
    }

    @Override
    /**
     * Return the size from the USER's perspective.
     */
    public int size() {
        return size;
    }

    @Override
    public int get(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("Tried to access position "
                    + pos + " of an array of size " + size);

        return data[pos];
    }

    @Override
    public void set(int pos, int value) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("Tried to access position "
                    + pos + " of an array of size " + size);

        data[pos] = value;
    }

    @Override
    public void append(int value) {
        if (size < data.length) // check if there's enough space in data[]
        {
            // we have enough space here.
            // add the new element into the correct location
            data[size] = value;
            size++;
        }
        else
        {
            expand();

            // actually add the new item to the end
            data[size] = value;
            size++;
        }

    }

    @Override
    public void prepend(int value) {
        if (size == data.length)  // array is full
            expand();

        for (int x = size; x > 0; x--) // shift all ints one spot to the right
        {
            data[x] = data[x - 1];
        }

        data[0] = value;
        size++;
    }

    public String toString()
    {
        // Build a string that represents how the user perceives the array:
        String dataString = "user view=[ ";
        for (int x = 0; x < size; x++)
            dataString += (data[x] + " ");
        dataString += "] ";

        // Add in the internal representation:
        dataString += ("internal view=" + Arrays.toString(data));
        return dataString + " size=" + size + " capacity=" + data.length;
    }

    private void expand()
    {
        // not enough space.  Expand the array.
        int[] newdata = new int[data.length + 3];

        // copy old data into new data
        for (int x = 0; x < size; x++)
        {
            newdata[x] = data[x];
        }

        data = newdata;
    }
}