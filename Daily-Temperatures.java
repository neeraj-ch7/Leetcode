1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) {
3        int n = temperatures.length;
4        Stack<Integer> st = new Stack<>();
5        int[] res = new int[n];
6        res[n-1] = 0;
7        st.push(n-1);
8        for( int i= n-2;i>= 0;i--){
9           while(!st.isEmpty() && temperatures[st.peek()]<= temperatures[i]){
10            st.pop();
11           }
12           if(st.isEmpty()){
13              res[i] = 0;
14           }else{
15            res[i] = st.peek() - i;
16           }
17            st.push(i);
18        }
19     return res;
20    }
21}