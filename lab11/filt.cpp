#include <iostream>
#include <vector>
using namespace std;

vector<int> readVals() {
  int val;
  vector<int> nums;
  cout << "Enter numbers:\n";
  while (cin >> val) {
    nums.push_back(val);
  }
  return nums;
}

void printVals(vector<int> nums) {
  for (int i = 0; i < nums.size(); i++) {
    cout << nums[i]<< " ";
  }
  cout << endl;
}

vector<int> filter(vector<int> nums) {
  vector<int> filt;
  for (int i = 0; i < nums.size(); i++) {
    if (nums[i] > 0) {
      filt.push_back(nums[i]);
    }
  }
  return filt;
}

int main(){
  vector<int> nums = readVals();
  cout << "Vector:\n";
  printVals(nums);
  cout << "Filtered vector:\n";
  vector<int> filt = filter(nums);
  printVals(filt);
  cout << "Original vector\n";
  printVals(nums);
  return 0;
}
