#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int maxAscendingSum(vector<int> &nums)
    {
        int maxSum = nums[0], currentSum = nums[0];

        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] > nums[i - 1])
            {
                currentSum += nums[i];
            }
            else
            {
                currentSum = nums[i];
            }
            maxSum = max(maxSum, currentSum);
        }

        return maxSum;
    }
};

int main()
{
    Solution sol;

    // Test cases
    vector<int> nums1 = {10, 20, 30, 5, 10, 50};
    cout << "Output: " << sol.maxAscendingSum(nums1) << endl;

    vector<int> nums2 = {10, 20, 30, 40, 50};
    cout << "Output: " << sol.maxAscendingSum(nums2) << endl;

    vector<int> nums3 = {12, 17, 15, 13, 10, 11, 12};
    cout << "Output: " << sol.maxAscendingSum(nums3) << endl;

    return 0;
}
