1class Solution {
2    public List<String> twoEditWords(String[] queries, String[] dictionary) {
3        List<String> result = new ArrayList<>();
4
5        for (String q : queries) {
6            for (String d : dictionary) {
7                if (isWithinTwoEdits(q, d)) {
8                    result.add(q);
9                    break; // no need to check further
10                }
11            }
12        }
13
14        return result;
15    }
16
17    private boolean isWithinTwoEdits(String a, String b) {
18        int diff = 0;
19
20        for (int i = 0; i < a.length(); i++) {
21            if (a.charAt(i) != b.charAt(i)) {
22                diff++;
23                if (diff > 2) return false;
24            }
25        }
26
27        return true;
28    }
29}