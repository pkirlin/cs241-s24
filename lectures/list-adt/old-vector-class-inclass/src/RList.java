public interface RList
{
    public int size();  // gets the size of the list

    public int get(int pos); // gets the item at a particular position

    public void set(int pos, int value);  // set the item at a particular position

    public void append(int value);  // adds to the end of the list

    public void prepend(int value);  // adds to the beginning of the list
}