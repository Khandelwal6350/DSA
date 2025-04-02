#include <vector>
#include <string>
#include <unordered_set>
#include <iostream>

using namespace std;

class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        int n = nums.size();
        unordered_set<string> numSet(nums.begin(), nums.end());
        
        for (int i = 0; i < (1 << n); i++) {
            string candidate = "";
            for (int j = n - 1; j >= 0; j--) {
                candidate += ((i & (1 << j)) ? '1' : '0');
            }
            if (numSet.find(candidate) == numSet.end()) {
                return candidate;
            }
        }
        return ""; 
    }
};

int main() {
    Solution solution;
    vector<string> nums = {"01", "10"};
    cout << "Different Binary String: " << solution.findDifferentBinaryString(nums) << endl;
    return 0;
}