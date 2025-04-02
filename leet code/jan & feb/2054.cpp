// two best non-overlapping events

#include <bits/stdc++.h>
using namespace std;

struct Event
{
    int time;
    int value;
    bool isStart;
};

class Solution
{
public:
    int maxTwoEvents(vector<vector<int>> &events)
    {
        int ans = 0;
        int maxValue = 0;
        vector<Event> evts;

        for (const vector<int> &event : events)
        {
            const int start = event[0];
            const int end = event[1];
            const int value = event[2];
            evts.push_back({start, value, true});
            evts.push_back({end + 1, value, false});
        }

        sort(evts.begin(), evts.end(), [](const Event &a, const Event &b)
             { return a.time == b.time ? a.isStart < b.isStart : a.time < b.time; });

        for (const Event &evt : evts)
        {
            if (evt.isStart)
                ans = max(ans, evt.value + maxValue);
            else
                maxValue = max(maxValue, evt.value);
        }

        return ans;
    }
};

int main()
{
    vector<vector<int>> events = {{1, 3, 4}, {2, 5, 6}, {7, 9, 8}};
    Solution solution;
    cout << "Maximum value of the events: " << solution.maxTwoEvents(events) << endl;
    return 0;
}
