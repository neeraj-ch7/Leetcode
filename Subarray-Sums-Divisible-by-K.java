1class Solution {
2    public int subarraysDivByK(int[] nums, int k) {
3        
4        int res =0;
5        int sum =0;
6        HashMap<Integer,Integer> freq = new HashMap<>();
7        freq.put(0,1);
8        
9        for(int i=0;i<nums.length;i++){
10            sum+=nums[i];
11            int rem = sum%k;
12            if(rem<0){
13                rem = rem + k;
14            }
15            res+=freq.getOrDefault(rem, 0);
16            freq.put(rem,freq.getOrDefault(rem, 0)+1);
17        }
18        return res;
19    }
20}