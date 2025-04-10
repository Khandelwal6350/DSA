#include <bits/stdc++.h>
#include <vector>

using namespace std; 

class Solution {
    public:
     vector<int> pivotArray(vector<int>& nums, int pivot) {
       vector<int> ans;
   
       for (const int num : nums)
         if (num < pivot)
           ans.push_back(num);
   
       for (const int num : nums)
         if (num == pivot)
           ans.push_back(num);
   
       for (const int num : nums)
         if (num > pivot)
           ans.push_back(num);
   
       return ans;
     }
   };