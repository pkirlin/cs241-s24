import java.util.Arrays;
import java.util.Iterator;

public class RArrayList implements RList, Iterable<Integer> {
    private int[] data;  // stores the actual array elements.
    private int size;  // stores the size of the array from the user's perspective.
    // We can get the current capacity of the data with data.length.

    private final static int SIZE_INCREMENT = 3;

    public RArrayList() {
        data = new int[SIZE_INCREMENT];
        size = 0;
    }

    @Override
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
        if (size == data.length)
            expand();

        data[size] = value;
        size++;
    }

    @Override
    public void prepend(int value) {
        if (size == data.length)
            expand();

        // slide everything to the right so we can put value at [0]
        for (int x = size; x > 0; x--) {
            data[x] = data[x - 1];
        }

        data[0] = value;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(data));
        sb.append(" size=");
        sb.append(size);
        sb.append(" cap=");
        sb.append(data.length);
        return sb.toString();
    }

    public Iterator<Integer> iterator()
    {
        RArrayListIterator it = new RArrayListIterator();
        return it;
    }

    private void expand()
    {
        int newlength = data.length + SIZE_INCREMENT;
        int[] newdata = new int[newlength];

        // copy over
        for (int x = 0; x < size; x++)
        {
            newdata[x] = data[x];
        }

        data = newdata;
    }

    private class RArrayListIterator implements Iterator<Integer>
    {
        private int currentPos;

        public RArrayListIterator()
        {
            currentPos = 0;
        }

        @Override
        public boolean hasNext() {
            if (currentPos < size)
                return true;
            else
                return false;
        }

        @Override
        public Integer next() {
            currentPos++;
            return data[currentPos-1];
        }
    }
}
