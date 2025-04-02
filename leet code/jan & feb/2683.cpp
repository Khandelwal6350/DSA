#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    bool doesValidArrayExist(vector<int> &derived)
    {
        int ones = 0;
        for (int i = 0; i < derived.size(); i++)
        {
            if (derived[i] != 0)
                ones++;
        }
        if (ones % 2 != 0)
            return false;
        else
            return true;
    }
};

int main()
{
    Solution s;
    vector<int> a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
    if (s.doesValidArrayExist(a))
    {
        cout << "true";
    }
    else
        cout << "false";
}