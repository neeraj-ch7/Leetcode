1
2 class Solution {
3    public List<String> twoEditWords(String[] queries, String[] dictionary) {
4        List<String> result = new ArrayList<>();
5
6        for (String q : queries) {
7            for (String d : dictionary) {
8                if (isWithinTwoEdits(q, d)) {
9                    result.add(q);
10                    break; // no need to check further
11                }
12            }
13        }
14
15        return result;
16    }
17
18    private boolean isWithinTwoEdits(String a, String b) {
19        int diff = 0;
20
21        for (int i = 0; i < a.length(); i++) {
22            if (a.charAt(i) != b.charAt(i)) {
23                diff++;
24                if (diff > 2) return false;
25            }
26        }
27
28        return true;
29    }
30}