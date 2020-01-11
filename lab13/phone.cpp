/*

  CSCI 455 C String lab

  See lab description for what it should do.  
  C++ tools allowed: cout, call by reference, ostream output

*/


// for C input functions (e.g., fgets used here)
#include <cstdio>

// C string functions
#include <cstring>

#include <iostream>


using namespace std;

const char NAME_DELIM = ':';
const int AREA_CODE_SIZE = 3;
const int PREFIX_SIZE = 3;
const int LINE_NO_SIZE = 4;
const int MAX_LINE_SIZE = 1024;  // including newline and terminating null char
const int MAX_NAME_SIZE = 1024;


void readField(char buffer[], int &start, int length, char* output) {
   strncpy(output, buffer+start, length);
   output[length] = '\0';
   start = start+length+1;
}


int main() {

   char buffer[MAX_LINE_SIZE];
   char name[MAX_NAME_SIZE];
   char areaCode[AREA_CODE_SIZE+1];
   char prefix[PREFIX_SIZE+1];
   char lineNumber[LINE_NO_SIZE+1];
   int start;
   char * pch;


   // fgets reads a line of input and puts it in a C string.  If the line of input
   // is longer than the buffer array only gets enough chars that fit (and ignores the
   // rest); this prevents it from overwriting the end of the array.
   // Unlike Java Scanner nextLine(), fgets also saves the newline in the buffer.
   // So after call, buffer will have 0 or more chars read from the line, 
   // then a newline char ('\n'), and then the null char ('\0')
   // note: the sizeof function below does not work with dynamic arrays.
   // fgets returns 0 (false) when it hits EOF
   // Note: stdin (third paremeter below) is the C version of cin or System.in


   while (fgets(buffer, sizeof(buffer), stdin)) {

      cout << "LINE READ: " << buffer;

      //* 
      // Exercise 1
      strncpy(areaCode, buffer, AREA_CODE_SIZE);
      areaCode[AREA_CODE_SIZE] = '\0';
      //cout << "area code: '"  << areaCode << "'" << endl;
      strncpy(prefix, buffer+AREA_CODE_SIZE+1, PREFIX_SIZE);
      prefix[PREFIX_SIZE] = '\0';
      //cout << "prefix: '"  << prefix << "'" << endl;
      strncpy(lineNumber, buffer+AREA_CODE_SIZE+PREFIX_SIZE+2, LINE_NO_SIZE);
      lineNumber[LINE_NO_SIZE] = '\0';
      //*/

      /* 
      // Exercise 2
      start = 0;

      readField(buffer, start, AREA_CODE_SIZE, areaCode);
      readField(buffer, start, PREFIX_SIZE, prefix);
      readField(buffer, start, LINE_NO_SIZE, lineNumber);
      //*/

      /*
      // Exercise 3
      start = 0;
      pch = strchr(buffer, NAME_DELIM);

      readField(buffer, start, pch - buffer, name);
      readField(buffer, start, AREA_CODE_SIZE, areaCode);
      readField(buffer, start, PREFIX_SIZE, prefix);
      readField(buffer, start, LINE_NO_SIZE, lineNumber);
      cout << "name read: '" << name << "'" << endl;
      //*/

      cout << "area code: '"  << areaCode << "'" << endl;
      cout << "prefix: '"  << prefix << "'" << endl;
      cout << "line number: '"  << lineNumber << "'" << endl;
      cout << endl;

   } 

}

