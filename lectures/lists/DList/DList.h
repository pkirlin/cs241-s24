//
// Created by Phillip Kirlin on 2019-01-31.
//

#ifndef DLIST_DLIST_H
#define DLIST_DLIST_H

#include <iostream>

using namespace std;

struct node
{
    node *prev = nullptr;
    node *next = nullptr;
    int data;
};

class DList
{
public:

    DList();                           // default ctor
    DList(const DList &other);   // copy ctor
    ~DList();                          // dtor

    DList &operator=(const DList &other);    // assignment operator

    bool isEmpty() const;       // test if this list is empty

    void clear();               // remove all the items in the list
    void append(int item);          // add a new item into the list
    void prepend(int item);

    void remove(int item);       // remove an item from the list (if it exists)

    bool contains(int item) const;
    bool insertAfter(int searchItem, int item);
    bool insertBefore(int searchItem, int item);

    friend ostream &operator<<(ostream &out, const DList &sortlist);  // for cout'ing

private:
    node *head = nullptr;
    node *tail = nullptr;
};


#endif //DLIST_DLIST_H
