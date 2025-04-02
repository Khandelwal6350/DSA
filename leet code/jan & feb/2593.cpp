// logic is simple first make a clone of nums then pull back the marked element and repeat the following the process

#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    long long findScore(vector<int> &nums)
    {
        int n = nums.size();
        long long score = 0;
        vector<bool> marked(n, false);

        vector<int> indices(n);
        for (int i = 0; i < n; ++i)
        {
            indices[i] = i;
        }
        sort(indices.begin(), indices.end(), [&nums](int a, int b)
             { return nums[a] < nums[b] || (nums[a] == nums[b] && a < b); });

        for (int idx : indices)
        {
            if (marked[idx])
                continue;

            score += nums[idx];

            marked[idx] = true;
            if (idx > 0)
                marked[idx - 1] = true;
            if (idx < n - 1)
                marked[idx + 1] = true;
        }

        return score;
    }
};