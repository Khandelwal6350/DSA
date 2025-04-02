#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

class Solution
{
public:
    int maxScoreSightseeingPair(vector<int> &values)
    {
        int maxScore = 0;
        int maxValueWithIndex = values[0];

        for (int j = 1; j < values.size(); ++j)
        {
            // we simply break eqn into 2 parts and maximizing the values[i]+i and calculating values[j]-j
            maxScore = max(maxScore, maxValueWithIndex + values[j] - j);
            maxValueWithIndex = max(maxValueWithIndex, values[j] + j);
        }

        return maxScore;
    }
};
int main()
{
    Solution s;
    vector<int> values = {1, 2, 3, 4, 5, 6, 7};
    cout << s.maxScoreSightseeingPair(values);
}