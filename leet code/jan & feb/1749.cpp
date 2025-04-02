#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int maxAbsoluteSum(vector<int>& nums) {
    int maxSum = 0, minSum = 0, currMax = 0, currMin = 0;
    
    for (int num : nums) {
        currMax = max(num, currMax + num);
        maxSum = max(maxSum, currMax);
        
        currMin = min(num, currMin + num);
        minSum = min(minSum, currMin);
    }
    
    return max(maxSum, abs(minSum));
}

int main() {
    vector<int> nums = {1, -3, 2, 3, -4};
    cout << maxAbsoluteSum(nums) << endl; // Output: 5
    
    vector<int> nums2 = {2, -5, 1, -4, 3, -2};
    cout << maxAbsoluteSum(nums2) << endl; // Output: 8
    
    return 0;
}
