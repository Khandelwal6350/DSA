#include <iostream>
#include <vector>
#include <algorithm>
#include <climits> // For INT_MAX

using namespace std;

class Solution {
public:
    int putMarbles(vector<int>& weights, int k) {
        int n = weights.size();
        vector<vector<int>> dp_max(n+1, vector<int>(k+1, 0));
        vector<vector<int>> dp_min(n+1, vector<int>(k+1, INT_MAX));

        for (int i = 1; i <= n; i++) {
            dp_max[i][1] = dp_min[i][1] = weights[0] + weights[i-1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= min(k, i); j++) {
                for (int m = j-1; m < i; m++) {
                    int cost = weights[m] + weights[i-1]; 
                    dp_max[i][j] = max(dp_max[i][j], dp_max[m][j-1] + cost);
                    dp_min[i][j] = min(dp_min[i][j], dp_min[m][j-1] + cost);
                }
            }
        }

        return dp_max[n][k] - dp_min[n][k];
    }
};