/*  Name: Yifan Chen
 *  USC NetID: ychen865
 *  CS 455 Fall 2019
 *
 *  See ecListFuncs.h for specification of each function.
 */


// for NULL
#include <cstdlib>

// in case you want to use assert statements
#include <cassert>

#include "ecListFuncs.h"

using namespace std;


void longestRun(ListType list, int & maxRunVal, int & maxRunLen) {

    int curRunVal, curRunLen;
    curRunVal = maxRunVal = list->data;
    curRunLen = maxRunLen = 0;

    // if there are nodes
    while (list) {

        // check if its the same value as the previous node
        if (list->data == curRunVal) {
            curRunLen ++;
            if (curRunLen > maxRunLen) {
                maxRunVal = curRunVal;
                maxRunLen = curRunLen;
            }
        } 
        // reset
        else {
            curRunVal = list->data;
            curRunLen = 1;
        }

        list = list->next;

    }

}


void removeMultiplesOf3(ListType & list) {

    ListType pre, head, tmp;
    pre = head = NULL;

    // if there are nodes
    while (list) {

        // the node is the multiples of 3
        if (list->data % 3 == 0) {
            tmp = list;
            list = list->next;
            delete tmp;
            continue;
        } 
        // if there is a previos node in the new list
        else if (pre) {
            pre->next = list;
            pre = pre->next;
        } 
        // find the first node for the new list
        else {
            pre = head = list;
        }

        list = list->next;

    }

    // close the new list
    if (pre) {
        pre->next = NULL;
    }
    list = head;

}


void insertMiddle(ListType & list, int midVal) {

    // handle case size = 0
    if (!list) {
        list = new Node(midVal);
        return;
    }
   
    int size = 0;
    ListType ptr1, ptr2;
    ptr1 = ptr2 = list;
   
    // get the size of the list
    while (ptr1) {
        size ++;
        ptr1 = ptr1->next;
    }

    // handle case size = 1
    if (size == 1) {
        list = new Node(midVal, list);
        return;
    }

    //insert midVal
    for (int i=0; i < (size/2)-1; i ++) {
        ptr2 = ptr2->next;
    }
    ListType midNode = new Node(midVal, ptr2->next);
    ptr2->next = midNode;

}


ListType merge(ListType list1, ListType list2) {

    // handle empty list
    if (!list1) {
        return list2;
    }
    else if (!list2) {
        return list1;
    }

    ListType pre, head, tmp;

    // find the first value of the list
    if (list1->data < list2->data) {
        pre = head = list1;
        list1 = list1->next;
    } 
    else {
        pre = head = list2;
        list2 = list2->next;
    }

    // merge two lists
    while (list1 && list2) {

        if (pre->data == list1->data) {
            tmp = list1;
            list1 = list1->next;
            delete tmp;
            continue;
        }
        else if (pre->data == list2->data) {
            tmp = list2;
            list2 = list2->next;
            delete tmp;
            continue;
        }

        if (list1->data < list2->data) {
            pre->next = list1;
            pre = pre->next;
            list1 = list1->next;
        } 
        else {
            pre->next = list2;
            pre = pre->next;
            list2 = list2->next;
        }

    }

    // merge the rest of the list
    if (list1) {
        if (pre->data == list1->data) {
            list1 = list1->next;
        }
        pre->next = list1;
    }
    else {
        if (pre->data == list2->data) {
            list2 = list2->next;
        }
        pre->next = list2;
    }
    
    return head;

}



