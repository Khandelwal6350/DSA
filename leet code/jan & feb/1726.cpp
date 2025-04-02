#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        unordered_map<int, int> productCount;
        int count = 0;
        
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int product = nums[i] * nums[j];
                productCount[product]++;
            }
        }
        
        for (auto& entry : productCount) {
            int freq = entry.second;
            if (freq > 1) {
                count += (freq * (freq - 1)) / 2 * 8;
            }
        }
        
        return count;
    }
};

int main() {
    Solution solution;
    vector<int> nums1 = {2, 3, 4, 6};
    vector<int> nums2 = {1, 2, 4, 5, 10};
    
    cout << "Output for [2,3,4,6]: " << solution.tupleSameProduct(nums1) << endl;
    cout << "Output for [1,2,4,5,10]: " << solution.tupleSameProduct(nums2) << endl;
    
    return 0;
}
