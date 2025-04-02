#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:
        void flip(vector<int> &nums, int i) {
            nums[i] ^= 1;
            if (i + 1 < nums.size()) nums[i + 1] ^= 1;
            if (i + 2 < nums.size()) nums[i + 2] ^= 1;
        }
    
        int minOperations(vector<int>& nums) {
            int n = nums.size();
            int operations = 0;
            
            for (int i = 0; i < n - 2; i++) {
                if (nums[i] == 0) {
                    flip(nums, i);
                    operations++;
                }
            }
    
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) return -1; 
            }
    
            return operations;
        }
    };