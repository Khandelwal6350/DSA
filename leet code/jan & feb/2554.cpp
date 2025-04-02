#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxCount(vector<int> &banned, int n, int maxSum)
    {
        unordered_set<int> bannedSet(banned.begin(), banned.end());
        int sum = 0, count = 0;

        for (int i = 1; i <= n; ++i)
        {
            if (bannedSet.find(i) == bannedSet.end() && sum + i <= maxSum)
            {
                sum += i;
                ++count;
            }
        }

        return count;
    }
};

int main()
{
    Solution s;
    vector<int> arr = {1, 2, 4};
    cout << s.maxCount(arr, 7, 5);
}