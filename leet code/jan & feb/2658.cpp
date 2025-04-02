#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int findMaxFish(vector<vector<int>> &grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        int maxFish = 0;

        vector<vector<bool>> visited(m, vector<bool>(n, false));

        // Directions for adjacent cells
        vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Helper function to perform BFS and calculate fish count
        auto bfs = [&](int startRow, int startCol)
        {
            int fishCount = 0;
            queue<pair<int, int>> q;
            q.push({startRow, startCol});
            visited[startRow][startCol] = true;

            while (!q.empty())
            {
                auto [row, col] = q.front();
                q.pop();
                fishCount += grid[row][col];

                for (auto [dx, dy] : directions)
                {
                    int newRow = row + dx;
                    int newCol = col + dy;

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] > 0 && !visited[newRow][newCol])
                    {
                        visited[newRow][newCol] = true;
                        q.push({newRow, newCol});
                    }
                }
            }

            return fishCount;
        };

        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (grid[i][j] > 0 && !visited[i][j])
                {
                    maxFish = max(maxFish, bfs(i, j));
                }
            }
        }

        return maxFish;
    }
};
