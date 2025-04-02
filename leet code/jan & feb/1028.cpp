#ifndef SOLUTION_H
#define SOLUTION_H

#include <string>
#include <cctype>

using namespace std; 

struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
 public:
  TreeNode* recoverFromPreorder(std::string traversal);

 private:
  TreeNode* recoverFromPreorder(const std::string& traversal, int depth, int& i);
};

#endif 
