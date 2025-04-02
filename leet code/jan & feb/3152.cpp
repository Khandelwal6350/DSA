// special array in leetcode

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<bool> isArraySpecial(vector<int> &nums, vector<vector<int>> &queries)
    {
        int n = nums.size();
        vector<int> sameParity(n - 1, 0);

        for (int i = 0; i < n - 1; ++i)
        {
            if ((nums[i] % 2) == (nums[i + 1] % 2))
            {
                sameParity[i] = 1;
            }
        }

        // Compute prefix sum of sameParity array
        vector<int> prefixSum(n, 0);
        for (int i = 1; i < n; ++i)
        {
            prefixSum[i] = prefixSum[i - 1] + sameParity[i - 1];
        }

        vector<bool> result;
        for (const auto &query : queries)
        {
            int fromi = query[0];
            int toi = query[1];
            if (toi == fromi)
            {
                result.push_back(true);
            }
            else
            {
                int sameCount = prefixSum[toi] - prefixSum[fromi];
                result.push_back(sameCount == 0);
            }
        }

        return result;
    }
};