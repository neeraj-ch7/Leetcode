1class Solution {
2    public int findMaxLength(int[] nums) {
3        
4        int zero =0;
5        int one = 0;
6        int res = 0;
7
8        Map<Integer,Integer> freq = new HashMap<>();
9
10        for(int i =0;i<nums.length;i++){
11            if(nums[i]==0){
12                zero++;
13            }else{
14                one++;
15            }
16            int diff= zero -one ;
17            if(diff == 0){
18            res = Math.max(res,i+1);
19            continue;
20            }
21            if (freq.containsKey(diff)==false){
22               freq.put(diff,i);
23            } else {
24              
25              int len =i- freq.get(diff);
26              res= Math.max(res,len);
27            }
28        }
29        return res;
30    }
31}