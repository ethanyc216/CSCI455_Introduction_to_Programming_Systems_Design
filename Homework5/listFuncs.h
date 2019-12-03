// Name: Yifan Chen
// USC NetID: ychen865
// CSCI 455 PA5
// Fall 2019


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  

struct Node {
    std::string key;
    int value;

    Node* next;

    Node(const std::string& theKey, int theValue);

    Node(const std::string& theKey, int theValue, Node* n);
};


typedef Node* ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/*
    Checks if the list contains the key. 
    If the list contains key, return true; otherwise, return false.
*/
bool contains(ListType& list, std::string key);

/*
    Create a new Node with given key and value and add to the front of the list.
    If key exists, return false; otherwise, add the node and return true.
*/
bool add(ListType& list, std::string key, int value);

/*
    Removes the node that contains the given key from the list. 
    If key exists, remove the node and return true; otherwise, return false.
*/
bool remove(ListType& list, std::string key);

/*
    Updates the value of the key. 
    If key exists in the list, update the value and return true; otherwise, return false.
*/
bool update(ListType& list, std::string key, int value);

/*
    Print out all the nodes in the list, one per line.
    Sample output:
    zhou 283
    sam 84
    babs 99
*/
void print(ListType list);

/*
    Return the size of the list.
*/
int getSize(ListType list);


// keep the following line at the end of the file
#endif
