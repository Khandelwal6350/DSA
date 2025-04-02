#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    bool isValidPartition(string s, int num, int index, int currentSum) {
        if (index == s.size()) {
            return currentSum == num;
        }
        
        int value = 0;
        for (int i = index; i < s.size(); ++i) {
            value = value * 10 + (s[i] - '0');
            if (value + currentSum <= num) {
                if (isValidPartition(s, num, i + 1, currentSum + value)) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
    
    int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            int square = i * i;
            string squareStr = to_string(square);
            if (isValidPartition(squareStr, i, 0, 0)) {
                sum += square;
            }
        }
        return sum;
    }
};

int main() {
    Solution sol;
    int n;
    cout << "Enter a number: ";
    cin >> n;
    cout << "Punishment Number: " << sol.punishmentNumber(n) << endl;
    return 0;
}
