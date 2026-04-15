1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n = words.length;
4        int minDist = Integer.MAX_VALUE;
5
6        for (int i = 0; i < n; i++) {
7            if (words[i].equals(target)) {
8                int diff = Math.abs(i - startIndex);
9                int dist = Math.min(diff, n - diff);
10                minDist = Math.min(minDist, dist);
11            }
12        }
13
14        return minDist == Integer.MAX_VALUE ? -1 : minDist;
15    }
16}