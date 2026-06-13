1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        int n = nums.length;
4        int[] res = new int[n];
5        Arrays.fill(res, -1);
6
7        Stack<Integer> st = new Stack<>();
8
9        for(int i = 2 * n - 1; i >= 0; i--) {
10            int idx = i % n;
11
12            while(!st.isEmpty() && st.peek() <= nums[idx]) {
13                st.pop();
14            }
15
16            if(i < n) {
17                if(!st.isEmpty()) {
18                    res[idx] = st.peek();
19                }
20            }
21
22            st.push(nums[idx]);
23        }
24
25        return res;
26    }
27}