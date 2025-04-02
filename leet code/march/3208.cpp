#include <bits/stdc++.h>

using namespace std; 

class Solution {
    public:
        int numberOfAlternatingGroups(vector<int>& colors, int k) {
            int n = colors.size();
            int ans = 0, alternating = 1;
    
            for (int i = 1; i < n + k - 1; i++) {
                if (colors[i % n] == colors[(i - 1) % n])
                    alternating = 1;  // Reset count if colors repeat
                else
                    alternating++;
    
                if (alternating >= k)
                    ans++;
            }
    
            return ans;
        }
    };
    
    