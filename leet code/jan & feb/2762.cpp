// continuous subarray
// using two pointer to solve this problem

#include <vector>
#include <cmath>
#include <iostream>
#include <algorithm>

using namespace std;

class Solution
{
public:
    long long continuousSubarrays(vector<int> &nums)
    {
        int n = nums.size();
        long long total = 0;
        int left = 0;
        int minVal = nums[0], maxVal = nums[0];

        for (int right = 0; right < n; ++right)
        {
            minVal = min(minVal, nums[right]);
            maxVal = max(maxVal, nums[right]);

            while (maxVal - minVal > 2)
            {
                ++left;
                minVal = *std::min_element(nums.begin() + left, nums.begin() + right + 1);
                maxVal = *std::max_element(nums.begin() + left, nums.begin() + right + 1);
            }
            total += (right - left + 1);
        }

        return total;
    }
};

int main()
{
    Solution solution;
    vector<int> nums1 = {65, 66, 67, 66, 66, 65, 64, 65, 65, 64};
    cout << "Output: " << solution.continuousSubarrays(nums1) << endl;

    vector<int> nums2 = {1, 2, 3};
    cout << "Output: " << solution.continuousSubarrays(nums2) << endl;

    return 0;
}
