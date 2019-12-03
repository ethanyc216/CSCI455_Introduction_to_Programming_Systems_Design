// Name: Yifan Chen
// USC NetID: ychen865
// CSCI 455 PA5
// Fall 2019


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string& theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string& theKey, int theValue, Node* n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

bool contains(ListType& list, string key) {
    
    ListType cur = list;

    while (cur != NULL) {        
        // Found
        if (cur->key == key) {
            return true;
        }
        cur = cur->next;
    }
    // Not found 
    return false;
    
}

bool add(ListType& list, string key, int value){
    
    // Already contains the key
    if (contains(list, key)) {
        return false;
    }
    // Create a node and add to the front of the list
    else {
        list = new Node(key, value, list);
        return true;
    }
    
}

bool remove(ListType& list, string key) {
    
    ListType cur = list; 
    ListType pre = NULL;
    ListType tmp = NULL;
    
    while (cur != NULL) {
        // Found key, remove it from the list
        if (cur->key == key) {
            tmp = cur;
            if (pre != NULL) {
                pre->next = cur->next;
            }
            else {
                list = list->next;
            }
            delete tmp;
            return true;
        }
        pre = cur;
        cur = cur->next;
    }
    // Not found
    return false;
    
}

bool update(ListType& list, string key, int value) {
    
    ListType cur = list;
    
    while (cur != NULL) {
        // Found key, update the value
        if (cur->key == key) {
            cur->value = value;
            return true;
        }
        cur = cur->next;
    }
    // Not found
    return false;
    
}

void print(ListType list) {

	ListType cur = list;
    
    // No nodes, print <empty>.
    if (list == NULL) {
        cout << "<empty>";
    }
    
    // Print Nodes:
    // key: value
    while (cur != NULL) {
        cout << cur->key << " " << cur->value << endl;
        cur = cur->next;
    }
    
}

int getSize(ListType list) {
    
    int size = 0;
    
    for (ListType cur = list ; cur != NULL ; cur = cur->next) {
        size ++;
    }
    
    return size;
}