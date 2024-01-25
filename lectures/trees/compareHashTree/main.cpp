#include <iostream>
#include <map>
#include <unordered_map>
#include <cstdlib>
#include <ctime>
#include <chrono>
#include <vector>

using namespace std;
using namespace std::chrono;

const int ACCOUNTS_MAX = 10000;

void test_insert_vec(vector<int>& accounts_vec, int loops)
{
    accounts_vec.clear();
    for (int t = 0; t < loops; t++)
    {
        for (int x = 0; x < ACCOUNTS_MAX; x++)
        {
            // generate random bank account number
            int account_num = rand();  // generates number between 0 and RAND_MAX (a built-in constant)
            int account_bal = rand();  // generates number between 0 and RAND_MAX (a built-in constant)
            accounts_vec.push_back(account_num);
            // simulate linear search
            for (int x = 0; x < accounts_vec.size(); x++)
                if (accounts_vec[x] == account_num) break;
        }
    }
}

void test_insert_bst(map<int, int>& accounts_bst, int loops)
{
    accounts_bst.clear();
    for (int t = 0; t < loops; t++)
    {
        for (int x = 0; x < ACCOUNTS_MAX*10; x++)
        {
            // generate random bank account number and balance
            int account_num = rand();  // generates number between 0 and RAND_MAX (a built-in constant)
            int account_bal = rand();  // generates number between 0 and RAND_MAX (a built-in constant)
            accounts_bst[account_num] = account_bal;
            accounts_bst.find(account_num);
        }
    }
}

void test_insert_hash(unordered_map<int, int>& accounts_hash, int loops)
{
    accounts_hash.clear();
    for (int t = 0; t < loops; t++)
    {
        for (int x = 0; x < ACCOUNTS_MAX*10; x++)
        {
            // generate random bank account number
            int account_num = rand();  // generates number between 0 and RAND_MAX (a built-in constant)
            int account_bal = rand();  // generates number between 0 and RAND_MAX (a built-in constant)
            accounts_hash[account_num] = account_bal;
            accounts_hash.find(account_num);
        }
    }
}

int main()
{
    vector<int> accounts_vec;
    map<int, int> accounts_bst;
    unordered_map<int, int> accounts_hash;

    srand(time(0)); // seed the random number generator

    const int LOOPS = 10;

    cout << "Vector" << endl;

    for (int loops = 1; loops <= 10; loops++)
    {
        auto start = high_resolution_clock::now();
        test_insert_vec(accounts_vec, loops);
        auto stop = high_resolution_clock::now();
        auto duration = duration_cast<microseconds>(stop - start);

        cout << "Time taken by function per insert: "
             << duration.count() / loops / 1000 << " milliseconds" << endl;
    }

    cout << "BST" << endl;

    for (int loops = 1; loops <= 10; loops++)
    {
        auto start = high_resolution_clock::now();
        test_insert_bst(accounts_bst, loops);
        auto stop = high_resolution_clock::now();
        auto duration = duration_cast<microseconds>(stop - start);

        cout << "Time taken by function per insert: "
             << duration.count() / loops / 1000 << " milliseconds" << endl;
    }

    cout << "Hash table" << endl;

    for (int loops = 1; loops <= 10; loops++)
    {
        auto start = high_resolution_clock::now();
        test_insert_hash(accounts_hash, loops);
        auto stop = high_resolution_clock::now();
        auto duration = duration_cast<microseconds>(stop - start);

        cout << "Time taken by function per insert: "
             << duration.count() / loops / 1000 << " milliseconds" << endl;
    }
}
