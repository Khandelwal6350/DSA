#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>> &prerequisites, vector<vector<int>> &queries)
    {
        vector<vector<bool>> graph(numCourses, vector<bool>(numCourses, false));

        for (const auto &edge : prerequisites)
        {
            graph[edge[0]][edge[1]] = true;
        }

        for (int k = 0; k < numCourses; ++k)
        {
            for (int i = 0; i < numCourses; ++i)
            {
                for (int j = 0; j < numCourses; ++j)
                {
                    if (graph[i][k] && graph[k][j])
                    {
                        graph[i][j] = true;
                    }
                }
            }
        }

        vector<bool> result;
        for (const auto &query : queries)
        {
            result.push_back(graph[query[0]][query[1]]);
        }

        return result;
    }
};

int main()
{
    Solution solution;
    int numCourses = 4;
    vector<vector<int>> prerequisites = {{0, 1}, {1, 2}, {2, 3}};
    vector<vector<int>> queries = {{0, 1}, {0, 3}, {1, 3}, {3, 0}};
    vector<bool> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
    for (bool res : result)
    {
        cout << (res ? "true" : "false") << " ";
    }
    return 0;
}