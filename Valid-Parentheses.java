1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4
5        for (int i = 0; i < s.length(); i++) {
6            char ch = s.charAt(i);
7
8            if (ch == '(' || ch == '{' || ch == '[') {
9                st.push(ch);
10            } else {
11                if (st.isEmpty()) return false;
12
13                if (ch == ')' && st.peek() == '(') {
14                    st.pop();
15                } else if (ch == '}' && st.peek() == '{') {
16                    st.pop();
17                } else if (ch == ']' && st.peek() == '[') {
18                    st.pop();
19                } else {
20                    return false;
21                }
22            }
23        }
24
25        return st.isEmpty();
26    }
27}