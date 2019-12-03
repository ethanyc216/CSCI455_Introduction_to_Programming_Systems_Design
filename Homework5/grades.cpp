// Name: Yifan Chen
// USC NetID: ychen865
// CSCI 455 PA5
// Fall 2019

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

// Process input commands
void run(Table* & grades);
// Insert this name and score in the grade table
void insert(Table* & grades, string name, int score);
// Change the score for name
void change(Table* & grades, string name, int newscore);
// Lookup the student
void lookup(Table* & grades, string name);
// Remove this student
void remove(Table* & grades, string name);
// Prints out all names and scores in the table
void print(Table* & grades);
// Prints out the number of entries in the table
void size(Table* & grades);
// Prints out statistics about the hash table at this point
void stats(Table* & grades);
// Prints out a brief command summary
void help();

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }

   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*

   //help();
   run(grades);

   return 0;
}

// Process input commands
void run(Table* & grades) {

   string command;
   string name;
   int score;
    
   while (true) {
        
      cout << "cmd> ";
      cin >> command;

      if (command == "insert") {
         cin >> name >> score;
         insert(grades, name, score);
      }
      else if (command == "change") {
         cin >> name >> score;
         change(grades, name, score);
      }
      else if (command == "lookup") {
         cin >> name;
         lookup(grades, name);
      }
      else if (command == "remove") {
         cin >> name;
         remove(grades, name);
      }
      else if (command == "print") {
         print(grades);
      }
      else if (command == "size") {
         size(grades);
      }
      else if (command == "stats") {
         stats(grades);
      }
      else if (command == "help") {
         help();
      }
      else if (command == "quit") {
         break;
      }
      else {
         cout << "ERROR: invalid command" << endl;
         help();
      }

   }
    
}

// Insert this name and score in the grade table
void insert(Table* & grades, string name, int score) {

   if (grades->insert(name, score)) {
      cout << "[SUCCESS] Name: " << name << ", Score: " << score << " added." << endl;
   }
   else {
      cout << "[FAIL] " << name << " exists." << endl;
   }

}

// Change the score for name
void change(Table* & grades, string name, int newScore) {

   int* value = grades->lookup(name);
   int oldScore = 0;

   if (value == NULL){
      cout << "[FAIL] " << name << " not exists." << endl;
   }
   else {
      oldScore = *value;
      *value = newScore;
      cout << "[SUCCESS] " << name << "'s score changed from " << oldScore  << " to " << newScore << "."<< endl;
   }
}

// Lookup the student
void lookup(Table* & grades, string name) {

   int* value = grades->lookup(name);
    
   if (value == NULL){
      cout << "[FAIL] " << name << " not exists." << endl;
   }
   else {
      cout << "[SUCCESS] " << name << "'s score is " << *value << "." << endl;
   }

}

// Remove this student
void remove(Table* & grades, string name) {

   if (grades->remove(name)) {
      cout << "[SUCCESS] " << name << " removed." << endl;
   }
   else {
      cout << "[FAIL] " << name << " not exists." << endl;
   }

}

// Prints out all names and scores in the table
void print(Table* & grades) {
   grades->printAll();
}

// Prints out the number of entries in the table
void size(Table* & grades) {
   cout << "The number of students is " << grades->numEntries() << endl;
}

// Prints out statistics about the hash table at this point
void stats(Table* & grades) {
   grades->hashStats(cout);
}

// Prints out a brief command summary
void help(){
    cout << "COMMAND SUMMARY:" << endl;
    cout << "  insert name score (Insert this name and score in the grade table.)" << endl;
    cout << "  change name newscore (Change the score for name.)" << endl;
    cout << "  lookup name (Lookup the student.)" << endl;
    cout << "  remove name (Remove this student.)" << endl;
    cout << "  print (Prints out all names and scores in the table.)" << endl;
    cout << "  size (Prints out the number of entries in the table.)" << endl;
    cout << "  stats (Prints out statistics about the hash table at this point.)" << endl;
    cout << "  help (Prints out a brief command summary.)" << endl;
    cout << "  quit (Exits the program.)" << endl;
}
