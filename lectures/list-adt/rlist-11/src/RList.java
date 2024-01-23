public interface RList {   // RhodesList
    public int size();  // get the size of the list
    public int get(int pos); // gets an element of the list at a specific position
    public void set(int pos, int value); // sets an element of the list at a specific position

    public void append(int value); // adds an element to the end of the list
    public void prepend(int value); // add an element to the beginning of the list
}
