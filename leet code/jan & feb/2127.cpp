// Maximum Employees to be invited to a meeting

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maximumInvitations(vector<int> &favorite)
    {
        int n = favorite.size();
        vector<int> indegree(n, 0);
        for (int i = 0; i < n; ++i)
        {
            indegree[favorite[i]]++;
        }

        // Step 1: Topological sort to remove non-cyclic nodes
        queue<int> q;
        vector<bool> visited(n, false);
        vector<int> chainLength(n, 0);

        for (int i = 0; i < n; ++i)
        {
            if (indegree[i] == 0)
            {
                q.push(i);
                visited[i] = true;
            }
        }

        while (!q.empty())
        {
            int node = q.front();
            q.pop();
            int next = favorite[node];
            chainLength[next] = max(chainLength[next], chainLength[node] + 1);
            if (--indegree[next] == 0)
            {
                q.push(next);
                visited[next] = true;
            }
        }

        // Step 2: Find cycles and calculate maximum invitations
        int maxCycle = 0, chainSum = 0;
        vector<bool> inCycle(n, false);

        for (int i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                int slow = i, fast = i;
                do
                {
                    slow = favorite[slow];
                    fast = favorite[favorite[fast]];
                } while (slow != fast);

                // Count the cycle length
                int cycleStart = slow, cycleLen = 0;
                do
                {
                    inCycle[cycleStart] = true;
                    visited[cycleStart] = true;
                    cycleLen++;
                    cycleStart = favorite[cycleStart];
                } while (cycleStart != slow);

                if (cycleLen == 2)
                {
                    // For 2-cycles, add the chains leading into each node
                    int chain1 = chainLength[slow];
                    int chain2 = chainLength[favorite[slow]];
                    chainSum += chain1 + chain2 + 2;
                }
                else
                {
                    maxCycle = max(maxCycle, cycleLen);
                }
            }
        }

        return max(maxCycle, chainSum);
    }
};
