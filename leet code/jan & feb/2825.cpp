#include <bits/stdc++.h>
using namespace std;

bool isSubsequence(const string &str1, const string &str2)
{
    int left = 0, right = 0;
    while (left < str1.size() && right < str2.size())
    {
        if (str1[left] == str2[right])
        {
            right++;
        }
        left++;
    }
    return right == str2.size();
}

bool canBeSubsequence(string str1, string str2)
{
    if (isSubsequence(str1, str2))
    {
        return true;
    }

    for (int mask = 1; mask < (1 << str1.size()); mask++)
    {
        string transformed = str1;
        for (int i = 0; i < str1.size(); i++)
        {
            if (mask & (1 << i))
            {
                transformed[i] = (transformed[i] - 'a' + 1) % 26 + 'a';
            }
        }
        if (isSubsequence(transformed, str2))
        {
            return true;
        }
    }
    return false;
}

int main()
{
    string str1 = "zc";
    string str2 = "ad";

    if (canBeSubsequence(str1, str2))
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }

    return 0;
}
