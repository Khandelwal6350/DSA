#include <iostream>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int numTilePossibilities(string tiles) {
        unordered_map<char, int> freq;
        for (char tile : tiles) {
            freq[tile]++;
        }
        return backtrack(freq);
    }
    
private:
    int backtrack(unordered_map<char, int>& freq) {
        int count = 0;
        for (auto& [ch, val] : freq) {
            if (val > 0) {
                count++;
                freq[ch]--;
                count += backtrack(freq);
                freq[ch]++;
            }
        }
        return count;
    }
};

int main() {
    Solution sol;
    cout << sol.numTilePossibilities("AAB") << endl;  
    cout << sol.numTilePossibilities("AAABBC") << endl; 
    cout << sol.numTilePossibilities("V") << endl;  
    return 0;
}
