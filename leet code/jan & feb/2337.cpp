// move pieces to obtain a string

// #include <bits/stdc++.h>

#include <iostream>
#include <string>
using namespace std;

bool canChange(string start, string target)
{
    const int n = start.size();

    for (int i = 1; i < n; i++)
    {
        for (int k = n - 1; k > 0; k--)
        {
            if (start[k] == 'L' && start[k - 1] == '_')
                swap(start[k], start[k - 1]);
            if (start[k] == 'R' && start[k + 1] == '_')
                swap(start[k], start[k + 1]);
            if (start == target)
            {
                return true;
            }
        }
    }

    cout << start;
    return false;
}

int main()
{
    string start = "_L__R__R_";
    string target = "L______RR";

    if (canChange(start, target))
    {
        cout << "True";
    }
    else
    {
        cout << "False";
    }
}