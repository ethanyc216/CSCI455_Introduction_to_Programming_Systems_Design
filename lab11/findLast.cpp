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
  for(int i = 0; i < nums.size(); i++){
    if(nums[i] > 0){
      filt.push_back(nums[i]);
    }
  }
  return filt;
}

int findLast(vector<int> nums, int target) {
  for(int i = nums.size()-1; i >= 0; i--){
    if (nums[i] == target) {
      return i;
    }
  }
  return -1;
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
  cout << "The last instance of 7 is at position " << findLast(nums, 7) << endl;
  return 0;
}
