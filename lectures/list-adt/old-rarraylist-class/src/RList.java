public interface RList
{
    public int size();  // gets the size of a list
    public int get(int pos);  // get the item at a given position
    public void set(int pos, int value);  // sets the item at the given position to the given value
    public void append(int value);  // add to end
    public void prepend(int value);   // add to beginning
}
