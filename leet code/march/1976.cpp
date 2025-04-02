#include <vector>
#include <queue>
#include <utility>
#include <limits>

using namespace std;

class Solution {
 public:
  int countPaths(int n, vector<vector<int>>& roads) {
    if (roads.empty()) return 0;  // Edge case: No roads given

    constexpr int kMod = 1'000'000'007;
    vector<vector<pair<int, int>>> graph(n);

    for (const vector<int>& road : roads) {
      int u = road[0], v = road[1], w = road[2];
      graph[u].emplace_back(v, w);
      graph[v].emplace_back(u, w);
    }

    return dijkstra(graph, 0, n - 1, kMod);
  }

 private:
  int dijkstra(const vector<vector<pair<int, int>>>& graph, int src, int dst, int mod) {
    using P = pair<long long, int>;  // (distance, node)
    priority_queue<P, vector<P>, greater<>> minHeap;

    vector<long long> dist(graph.size(), numeric_limits<long long>::max());
    vector<int> ways(graph.size(), 0);

    dist[src] = 0;
    ways[src] = 1;
    minHeap.emplace(0, src);

    while (!minHeap.empty()) {
      auto [d, u] = minHeap.top();
      minHeap.pop();

      if (d > dist[u]) continue;  // Ignore outdated distances

      for (const auto& [v, w] : graph[u]) {
        if (d + w < dist[v]) {
          dist[v] = d + w;
          ways[v] = ways[u];
          minHeap.emplace(dist[v], v);
        } else if (d + w == dist[v]) {
          ways[v] = (ways[v] + ways[u]) % mod;
        }
      }
    }

    return ways[dst];
  }
};
