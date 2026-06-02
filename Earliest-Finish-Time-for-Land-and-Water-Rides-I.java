1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3                                  int[] waterStartTime, int[] waterDuration) {
4
5        int ans = Integer.MAX_VALUE;
6
7        for (int i = 0; i < landStartTime.length; i++) {
8            for (int j = 0; j < waterStartTime.length; j++) {
9
10                // Land -> Water
11                int landFinish = landStartTime[i] + landDuration[i];
12                int waterStart = Math.max(landFinish, waterStartTime[j]);
13                int finish1 = waterStart + waterDuration[j];
14
15                // Water -> Land
16                int waterFinish = waterStartTime[j] + waterDuration[j];
17                int landStart = Math.max(waterFinish, landStartTime[i]);
18                int finish2 = landStart + landDuration[i];
19
20                ans = Math.min(ans, Math.min(finish1, finish2));
21            }
22        }
23
24        return ans;
25    }
26}