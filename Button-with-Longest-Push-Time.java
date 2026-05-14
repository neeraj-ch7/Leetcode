1class Solution {
2    public int buttonWithLongestTime(int[][] events) {
3        int maxTime = events[0][1];  // first event time
4        int result = events[0][0];   // first button index
5        
6        for (int i = 1; i < events.length; i++) {
7            int time = events[i][1] - events[i - 1][1];
8            
9            if (time > maxTime || (time == maxTime && events[i][0] < result)) {
10                maxTime = time;
11                result = events[i][0];
12            }
13        }
14        
15        return result;
16    }
17}