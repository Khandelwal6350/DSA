#include <iostream>
#include <vector>
using namespace std;

vector<int> applyOperations(vector<int>& nums) {
    int n = nums.size();

    for (int i = 0; i < n - 1; ++i) {
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2; 
            nums[i + 1] = 0; 
        }
    }

    vector<int> result;
    for (int num : nums) {
        if (num != 0) {
            result.push_back(num);
        }
    }

    result.resize(n, 0);
    
    return result;
}

int main() {
    vector<int> nums = {1, 2, 2, 1, 1, 0};
    vector<int> result = applyOperations(nums);

    for (int num : result) {
        cout << num << " ";
    }

    return 0;
}
