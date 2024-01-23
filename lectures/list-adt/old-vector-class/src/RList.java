public interface RList {
    /**
     * Get the size of this list.
     */
    public int size();

    /**
     * Returns the item in this list at position pos.
     */
    public int get(int pos) throws IndexOutOfBoundsException;

    /**
     * Set the item in this list at position pos.
     */
    public void set(int pos, int value) throws IndexOutOfBoundsException;

    /**
     * Append an item to the end of this list.
     */
    public void append(int value);

    /**
     * Prepend an item to the beginning of this list.
     */
    public void prepend(int value);
}
