#ifndef SOLUTION_H
#define SOLUTION_H

#include <vector>
#include <unordered_map>

using namespace std;

struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
 public:
  TreeNode* constructFromPrePost(std::vector<int>& pre, std::vector<int>& post);

 private:
  TreeNode* build(const std::vector<int>& pre, int preStart, int preEnd,
                  const std::vector<int>& post, int postStart, int postEnd,
                  const std::unordered_map<int, int>& postToIndex);
};

#endif 
