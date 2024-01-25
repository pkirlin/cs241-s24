import java.util.ArrayList;

class KVPair
{
    int key;
    double value;
}

public class ArrayMap {
    private ArrayList<KVPair> kvList = new ArrayList<KVPair>();

    public void put(int key, double value)
    {
        KVPair newNode = new KVPair();
        newNode.key = key;
        newNode.value = value;
        kvList.add(newNode);
    }

    public double get(int searchKey)
    {
        for (int x = 0; x < kvList.size(); x++)
        {
            KVPair node = kvList.get(x);
            if (node.key == searchKey)
            {
                return node.value;
            }
        }
        return 0;
    }
}
