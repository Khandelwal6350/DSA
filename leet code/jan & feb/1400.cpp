// construct K palindrome strings

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canConstruct(string s, int k)
    {
        int n = s.size();
        if (k > n)
            return false;
        if (k == n)
            return true;
        vector<int> hash(26, 0);
        for (int i = 0; i < n; i++)
        {
            hash[s[i] - 'a']++;
        }
        int odd_count = 0;
        for (int i = 0; i < 26; i++)
        {
            if (hash[i] % 2 != 0)
                odd_count++;
        }
        if (odd_count > k)
            return false;
        else
            return true;
    }
};

int main()
{
    Solution s;
}