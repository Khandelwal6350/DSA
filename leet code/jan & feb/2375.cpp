#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string smallestNumber(string pattern) {
        string result = "";
        stack<int> stk;
        int num = 1;
        
        for (int i = 0; i <= pattern.size(); i++) {
            stk.push(num++);
            
            if (i == pattern.size() || pattern[i] == 'I') {
                while (!stk.empty()) {
                    result += to_string(stk.top());
                    stk.pop();
                }
            }
        }
        
        return result;
    }
};

int main() {
    Solution sol;
    cout << sol.smallestNumber("IIIDIDDD") << endl; 
    cout << sol.smallestNumber("DDD") << endl;    
    return 0;
}
