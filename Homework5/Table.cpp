// Name: Yifan Chen
// USC NetID: ychen865
// CSCI 455 PA5
// Fall 2019

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
	num = 0;
	hashSize = HASH_SIZE;
	data = new ListType[hashSize]();
}


Table::Table(unsigned int hSize) {
	num = 0;
	hashSize = hSize;
	data = new ListType[hashSize]();
}


int * Table::lookup(const string &key) {

   unsigned int hash = hashCode(key);
    
    if (contains(data[hash], key)) {
        for (ListType cur = data[hash];; cur = cur->next) {
        	if (cur->key == key) {
        		return &(cur->value);
        	}
        }
    }
    else{
        return NULL;
    }

}

bool Table::remove(const string &key) {

   unsigned int hash = hashCode(key);
    
    if (::remove(data[hash], key)) {
        num --;
        return true;
    }
    else {
        return false;
    }

}

bool Table::insert(const string &key, int value) {
   
   unsigned int hash = hashCode(key);
    
    if (add(data[hash], key, value)) {
        num ++;
        return true;
    }
    else {
        return false;
    }

}

int Table::numEntries() const {
   return num;
}


void Table::printAll() const {

	for (int i = 0 ; i < hashSize ; i ++) {
        if (data[i] != NULL) {
            print(data[i]);
        }
    }

}

void Table::hashStats(ostream &out) const {

	out << "number of buckets: " << hashSize << endl;
    out << "number of entries: " << num << endl;
    out << "number of non-empty buckets: " << numNonEmpty() << endl;
    out << "longest chain: " << longestChain() << endl;
  
}


// add definitions for your private methods here

int Table::numNonEmpty() const {
    
    int numNon = 0;
    
    for (int i = 0 ; i < hashSize ; i ++) {
        if (data[i] != NULL) {
            numNon ++;
        }
    }
    
    return numNon;

}

int Table::longestChain() const {
    
    int longest = 0;
    int size = 0;
    
    for (int i = 0 ; i < hashSize ; i ++) {
        if (data[i] != NULL) {
            size = getSize(data[i]);
            if (size > longest){
                longest = size;
            }
        }
    }
    
    return longest;
    
}
