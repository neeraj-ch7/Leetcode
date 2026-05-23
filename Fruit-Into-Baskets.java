1class Solution {
2    public int totalFruit(int[] fruits) {
3        int n =fruits.length;
4        int low=0, res = -1;
5        HashMap<Integer,Integer> freq = new HashMap<>();
6
7        for( int high =0;high <n;high++){
8              freq.put(fruits[high],freq.getOrDefault(fruits[high],0)+1);
9
10              while(freq.size()>2){
11                int left=fruits[low];
12                freq.put(left,freq.get(left)-1);
13                if(freq.get(left)==0){
14                    freq.remove(left);
15                }
16                    low++;
17               
18              }
19              res=Math.max(res,high-low+1);
20        }
21       return res;
22    }
23}