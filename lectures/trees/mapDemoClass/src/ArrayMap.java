import java.util.*;

class KVPair
{
    int acctNum;
    double balance;
}

class ArrayMap
{
    private ArrayList<KVPair> list = new ArrayList<KVPair>();

    public void put(int acctNum, double balance)  // O(n)
    {
        KVPair newpair = new KVPair();
        newpair.acctNum = acctNum;
        newpair.balance = balance;
        list.add(newpair);
    }

    public double get(int acctNumLookingFor)  // O(n)
    {
        for (int x = 0; x < list.size(); x++)
        {
            KVPair pair = list.get(x);
            if (pair.acctNum == acctNumLookingFor)
            {
                return pair.balance;
            }
        }
        return -1;
    }

}