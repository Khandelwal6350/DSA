#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string removeOccurrences(string s, string part) {
        size_t pos = s.find(part);
        while (pos != string::npos) { 
            s.erase(pos, part.length());
            pos = s.find(part);  
        }
        return s;
    }
};

int main() {
    Solution solution;
    
    string s1 = "daabcbaabcbc";
    string part1 = "abc";
    cout << "Output: " << solution.removeOccurrences(s1, part1) << endl; 

    string s2 = "axxxxyyyyb";
    string part2 = "xy";
    cout << "Output: " << solution.removeOccurrences(s2, part2) << endl; 

    return 0;
}
