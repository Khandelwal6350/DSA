#include <vector>
#include <numeric>
using namespace std;

class Solution
{
public:
    vector<int> findRedundantConnection(vector<vector<int>> &edges)
    {
        int n = edges.size();
        vector<int> parent(n + 1);
        vector<int> rank(n + 1, 0);

        iota(parent.begin(), parent.end(), 0);

        auto find = [&](int x)
        {
            while (x != parent[x])
            {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        };

        auto unite = [&](int x, int y)
        {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return false;

            if (rank[rootX] > rank[rootY])
            {
                parent[rootY] = rootX;
            }
            else if (rank[rootX] < rank[rootY])
            {
                parent[rootX] = rootY;
            }
            else
            {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        };

        for (const auto &edge : edges)
        {
            if (!unite(edge[0], edge[1]))
            {
                return edge;
            }
        }

        return {};
    }
};
