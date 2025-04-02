// CLEAR DIGITS 

// You are given a string s.

// Your task is to remove all digits by doing this operation repeatedly:

// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.

 

// Example 1:

// Input: s = "abc"

// Output: "abc"

// Explanation:

// There is no digit in the string.

// Example 2:

// Input: s = "cb34"

// Output: ""

// Explanation:

// First, we apply the operation on s[2], and s becomes "c4".

// Then we apply the operation on s[1], and s becomes "".


#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string clearDigits(string s) {
        string result;
        for (char c : s) {
            if (isdigit(c)) {
                if (!result.empty()) {
                    result.pop_back(); 
                }
            } else {
                result.push_back(c);
            }
        }
        return result;
    }
};

int main() {
    Solution solution;
    string s;
    cout << "Enter the string: ";
    cin >> s;
    cout << "Result: " << solution.clearDigits(s) << endl;
    return 0;
}
