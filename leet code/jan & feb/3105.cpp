#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int longestMonotonicSubarray(vector<int> &nums)
    {
        int ans = 1;
        int increasing = 1;
        int decreasing = 1;

        for (size_t i = 1; i < nums.size(); ++i)
        {
            if (nums[i] > nums[i - 1])
            {
                increasing += 1;
                decreasing = 1;
            }
            else if (nums[i] < nums[i - 1])
            {
                decreasing += 1;
                increasing = 1;
            }
            else
            {
                increasing = 1;
                decreasing = 1;
            }
            ans = max({ans, increasing, decreasing});
        }

        return ans;
    }
};

int main()
{
    vector<int> nums = {1, 4, 3, 3, 2};
    Solution sol;
    int ret = sol.longestMonotonicSubarray(nums);
    cout << "Longest monotonic subarray length: " << ret << endl;
    return 0;
}
