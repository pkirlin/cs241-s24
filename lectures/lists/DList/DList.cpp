#include "DList.h"
#include <iostream>

// Constructs an empty SortedList.
DList::DList() : head(nullptr), tail(nullptr)
{}

// Constructs a new SortedList that is a copy of other.
DList::DList(const DList &other)
{
    if (other.isEmpty())      // empty list?
    {
        head = tail = nullptr;
    }
    else
    {
        // copy head first
        head = new node;
        head->data = other.head->data;
        head->next = nullptr;
        head->prev = nullptr;

        node *othercurr = other.head;
        node *newprev = head;
        othercurr = othercurr->next;
        while (othercurr != nullptr)
        {
            node *newnode = new node;
            newnode->data = othercurr->data;
            newnode->prev = newprev;
            newnode->next = nullptr;
            newprev->next = newnode;
            othercurr = othercurr->next;
            newprev = newprev->next; // aka newnode
        }
        tail = newprev;
    }
}

// Makes this SortedList equal to the other SortedList by copying it.
DList &DList::operator=(const DList &other)
{
    // check for self-assignment
    if (&other == this)
        return *this;

    clear();
    if (other.isEmpty())      // empty list?
    {
        head = tail = nullptr;
    }
    else
    {
        // copy head first
        head = new node;
        head->data = other.head->data;
        head->next = nullptr;
        head->prev = nullptr;

        node *othercurr = other.head;
        node *newprev = head;
        othercurr = othercurr->next;
        while (othercurr != nullptr)
        {
            node *newnode = new node;
            newnode->data = othercurr->data;
            newnode->prev = newprev;
            newnode->next = nullptr;
            newprev->next = newnode;
            othercurr = othercurr->next;
            newprev = newprev->next; // aka newnode
        }
        tail = newprev;
    }
    return *this;
}

// Destroys this SortedList.
DList::~DList()
{
    clear();
}

// Clears this SortedList (removes all the elements).
void DList::clear()
{
    // walk through the list, deleting pieces
    node *curr = head;
    while (curr != nullptr)
    {
        node *deleteme = curr;
        curr = curr->next;
        delete deleteme;
    }
    head = tail = nullptr;
}

// Add to the end of the list
void DList::append(int item)
{
    if (isEmpty()) // empty list
    {
        node *newnode = new node;
        newnode->data = item;
        newnode->next = nullptr;
        newnode->prev = nullptr;
        head = tail = newnode;
    }
    else
    {
        // non empty list
        node *newnode = new node;
        newnode->data = item;
        newnode->next = nullptr;
        newnode->prev = tail;
        tail->next = newnode;
        tail = newnode;
    }
}

bool DList::insertAfter(int searchItem, int item)
{
    if (isEmpty())
    {
        return false; // empty list won't find searchItem
    }
    else if (head == tail) // one item
    {
        if (tail->data == searchItem)  // item found, insertAfter == append
        {
            append(item);
            return true;
        }
        else
        {
            return false;  // not found
        }
    }
    else
    {
        // more than 1 items, do a search
        node *curr = head;
        while (curr != nullptr && curr->data != searchItem)
        {
            curr = curr->next;
        }
        // here, either curr is null or we found the item
        if (curr == nullptr)
        {
            // item not found
            return false;
        }
        else if (curr == tail) // item found at end, inserting at end, do append
        {
            append(item);
            return true;
        }
        else
        {
            // item found in middle of list (or head)
            node *newnode = new node;
            newnode->data = item;
            newnode->next = curr->next;
            newnode->prev = curr;
            curr->next = newnode;
            newnode->next->prev = newnode;
            return true;
        }
    }
}

bool DList::insertBefore(int searchItem, int item)
{
    if (isEmpty())
    {
        return false; // empty list won't find searchItem
    }
    else if (head == tail) // one item
    {
        if (head->data == searchItem)  // item found, insertBefore == prepend
        {
            prepend(item);
            return true;
        }
        else
        {
            return false;  // not found
        }
    }
    else
    {
        // more than 1 item, do a search
        node *curr = head;
        while (curr != nullptr && curr->data != searchItem)
        {
            curr = curr->next;
        }
        // here, either curr is null or we found the item
        if (curr == nullptr)
        {
            // item not found
            return false;
        }
        else if (curr == head) // item found at end, inserting at end, do append
        {
            prepend(item);
            return true;
        }
        else
        {
            // item found in middle of list (or tail)
            node *newnode = new node;
            newnode->data = item;
            newnode->prev = curr->prev;
            newnode->next = curr;
            curr->prev = newnode;
            newnode->prev->next = newnode;
            return true;
        }
    }
}

void DList::prepend(int item)
{
    if (isEmpty()) // empty list
    {
        node *newnode = new node;
        newnode->data = item;
        newnode->next = nullptr;
        newnode->prev = nullptr;
        head = tail = new node;
    }
    else
    {
        // non empty list
        node *newnode = new node;
        newnode->data = item;
        newnode->next = head;
        newnode->prev = nullptr;
        head->prev = newnode;
        head = newnode;
    }
}

bool DList::isEmpty() const
{
    return head == nullptr;
}

// Standard overload for output to a stream.
// Output should be of the form:
// [item0 item1 item2...item(n-1)] size=n [item(n-1) item(n-2) ... item1] size=m
// where n and m are manually determined from the traversal loops.
// Note that in the real world, the output would not give this level of detail, but
// we're using this output to help with debugging as well.
ostream &operator<<(ostream &out, const DList &sortlist)
{
    if (sortlist.head == nullptr)
        out << "[] size=0";
    else
    {
        int ctr = 0;
        out << "[";
        node *curr = sortlist.head;
        while (curr != nullptr)
        {
            out << curr->data;
            if (curr != sortlist.tail) out << " ";
            curr = curr->next;
            ctr++;
        }
        out << "] size=" << ctr << " ";

        out << "[";
        curr = sortlist.tail;
        ctr = 0;
        while (curr != nullptr)
        {
            out << curr->data;
            if (curr != sortlist.head) out << " ";
            curr = curr->prev;
            ctr++;
        }
        out << "] size=" << ctr;
    }

    return out;
}

// Removes an item from this DList.
// Traversing the list to find the appropriate position will be either forwards or
// backwards depending upon the number being searched for; the list guesses which direction will
// be faster.  Returns the number of elements traversed.
void DList::remove(int item)
{
    if (isEmpty())      // empty list?
    {
        return;
    }
    else if (head == tail)  // one item
    {
        if (head->data == item)// delete only item in list, now empty
        {
            delete head;
            head = tail = nullptr;
        }
        return;
    }
    else // have to walk list to find spot.  Head & tail might need to change.  Size is >= 2.
    {
        node *curr = head;

        while (curr != nullptr && curr->data != item)
        {
            curr = curr->next;
        }

        // curr is now pointing to the item to delete, or it's null.
        // if curr is null, then we walked off the end of the list, and our item isn't here, so return.
        if (curr == nullptr)
            return;
        else
        {
            // curr is pointing to the item to delete.  curr might be head or tail.
            if (curr == head)
            {
                head->next->prev = nullptr;
                head = head->next;
                delete curr;
            }
            else if (curr == tail)
            {
                tail->prev->next = nullptr;
                tail = tail->prev;
                delete curr;
            }
            else
            {
                // deleting somewhere in the middle
                curr->next->prev = curr->prev;
                curr->prev->next = curr->next;
                delete curr;
            }
            return;
        }
    }
}

