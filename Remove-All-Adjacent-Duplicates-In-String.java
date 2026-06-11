1class Solution {
2    public String removeDuplicates(String s) {
3        Stack<Character> st = new Stack<>();
4         
5         for(int i =0;i<s.length();i++){
6            if(st.isEmpty()){
7                st.push(s.charAt(i));
8                continue;
9            }
10            if(st.peek()==s.charAt(i)){
11                st.pop();
12                continue;
13            }
14            st.push(s.charAt(i));
15         }
16        StringBuilder sb = new StringBuilder();
17       
18        while(!st.isEmpty()){
19            sb.append(st.pop());
20        }
21        return sb.reverse().toString();
22    }
23}