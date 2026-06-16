1class Solution {
2    public String removeDuplicates(String s, int k) {
3
4        int n = s.length();
5
6        Stack<Pair> st = new Stack<>();
7
8        for (int i = 0; i < n; i++) {
9
10            char c = s.charAt(i);
11
12            if (st.isEmpty()) {
13                st.push(new Pair(c, 1));
14                continue;
15            }
16
17            if (st.peek().ch != c) {
18                st.push(new Pair(c, 1));
19                continue;
20            }
21
22            if (st.peek().count < (k - 1)) {
23
24                Pair p = st.pop();
25
26                st.push(new Pair(p.ch, p.count + 1));
27
28                continue;
29            }
30
31            st.pop();
32        }
33
34        StringBuilder res = new StringBuilder();
35
36        while (!st.isEmpty()) {
37
38            Pair p = st.pop();
39
40            while (p.count-- > 0) {
41                res.append(p.ch);
42            }
43        }
44
45        return res.reverse().toString();
46    }
47}
48
49class Pair {
50    char ch;
51    int count;
52
53    Pair(char ch, int count) {
54        this.ch = ch;
55        this.count = count;
56    }
57}