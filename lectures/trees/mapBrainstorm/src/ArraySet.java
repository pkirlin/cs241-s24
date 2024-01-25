import java.util.ArrayList;

public class ArraySet {
    private ArrayList<Integer> members = new ArrayList<Integer>();

    public void add(int value)
    {
        members.add(value);
    }

    public boolean contains(int searchValue)
    {
        for (int x = 0; x < members.size(); x++)
        {
            if (members.get(x) == searchValue)
            {
                return true;
            }
        }
        return false;
    }
}
