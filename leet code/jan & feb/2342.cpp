#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maximumSum(vector<int>& nums) {
        unordered_map<int, int> digitSumMap;
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (digitSumMap.find(digitSum) != digitSumMap.end()) {
                maxSum = max(maxSum, digitSumMap[digitSum] + num);
                digitSumMap[digitSum] = max(digitSumMap[digitSum], num);
            } else {
                digitSumMap[digitSum] = num;
            }
        }

        return maxSum;
    }

private:
    int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
};

int main() {
    Solution solution;
    
    vector<int> nums1 = {18, 43, 36, 13, 7};
    cout << "Output for nums1: " << solution.maximumSum(nums1) << endl;

    vector<int> nums2 = {10, 12, 19, 14};
    cout << "Output for nums2: " << solution.maximumSum(nums2) << endl;

    return 0;
}
