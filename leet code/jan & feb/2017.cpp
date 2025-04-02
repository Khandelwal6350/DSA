// Grid Game

// Explanation
// sumTop: Total points in the top row (grid[0]).
// sumBottom: Accumulated points collected by the first robot in the bottom row (grid[1]).
// ans: Stores the minimum points the second robot can collect when both play optimally.

// Optimal Path Calculation:
// Iterate through each column i.
// sumTop -= grid[0][i]: After the first robot skips column i in the top row, subtract its points.
// Calculate max(sumTop, sumBottom): The second robot can either take points from the top or bottom row. The first robot aims to minimize this maximum.
// Update ans with the minimum value of max(sumTop, sumBottom).

// Return the Result:
// After processing all columns, ans holds the result.

#include <vector>
#include <numeric>
#include <algorithm>
#include <climits>

using namespace std;

class Solution
{
public:
    long long gridGame(vector<vector<int>> &grid)
    {
        const int n = grid[0].size();
        long long ans = LLONG_MAX;
        long long sumTop = accumulate(grid[0].begin(), grid[0].end(), 0LL);
        long long sumBottom = 0;

        for (int i = 0; i < n; ++i)
        {
            sumTop -= grid[0][i];
            ans = min(ans, max(sumTop, sumBottom));
            sumBottom += grid[1][i];
        }

        return ans;
    }
};
