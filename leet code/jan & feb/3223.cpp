// minimum length of string after operation

#include <bits/stdc++.h>
using namespace std;

int minLength(string s)
{
    stack<char> st;
    for (char c : s)
    {
        // If the stack is not empty and the top element is equal to the current character, pop it
        if (!st.empty() && st.top() == c)
        {
            st.pop();
        }
        else
        {
            // Otherwise, push the character onto the stack
            st.push(c);
        }
    }
    // The size of the stack represents the minimum length of the final string
    return st.size();
}

int main()
{
    string s1 = "abaacbcbb";
    string s2 = "aa";

    cout << "Input: " << s1 << ", Output: " << minLength(s1) << endl; // Output: 5
    cout << "Input: " << s2 << ", Output: " << minLength(s2) << endl; // Output: 2

    return 0;
}
