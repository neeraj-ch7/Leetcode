1import java.util.Stack;
2
3class Solution {
4    public String removeDuplicates(String s) {
5        Stack<Character> st = new Stack<>();
6         
7         for(int i =0;i<s.length();i++){
8            if(st.isEmpty()){
9                st.push(s.charAt(i));
10                continue;
11            }
12            if(st.peek()==s.charAt(i)){
13                st.pop();
14                continue;
15            }
16            st.push(s.charAt(i));
17         }
18        StringBuilder sb = new StringBuilder();
19       
20        while(!st.isEmpty()){
21            sb.append(st.pop());
22        }
23        return sb.reverse().toString();
24    }
25}