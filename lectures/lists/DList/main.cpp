#include <iostream>
#include "DList.h"

int main()
{
    DList list;
    /*cout << list << endl;
    list.append(5);
    cout << list<< endl;;
    list.append(15);
    cout << list<< endl;;
    list.append(25);
    cout << list<< endl;;
    list.append(35);
    cout << list<< endl;;
    list.append(45);
    cout << list<< endl;;

    list.prepend(-5);
    cout << list<< endl;;
    list.append(-15);
    cout << list<< endl;;
    list.append(-25);
    cout << list<< endl;;
    list.append(-35);
    cout << list<< endl;;
    list.append(-45);
    cout << list<< endl;;*/

    list.append(5);
    cout << list << endl;
    list.insertAfter(5, 10);
    cout << list << endl;
    list.insertAfter(5, 7);
    cout << list << endl;
    list.insertAfter(10, 15);
    cout << list << endl;
    list.insertAfter(5, 6);
    cout << list << endl;

    list.clear();list.append(5);
    cout << list << endl;
    list.insertBefore(5, 10);
    cout << list << endl;
    list.insertBefore(5, 7);
    cout << list << endl;
    list.insertBefore(10, 15);
    cout << list << endl;
    list.insertBefore(5, 6);
    cout << list << endl;

    DList list2 = list;
    cout << list2 <<endl;
}