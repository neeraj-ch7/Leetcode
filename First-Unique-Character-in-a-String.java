1class Solution {
2    public int firstUniqChar(String s) {
3        
4        HashMap<Character,Integer> freq = new HashMap<>();
5        int n = s.length();
6        int i;
7        for(i =0;i<n;i++){
8            char c = s.charAt(i);
9            freq.put(c,freq.getOrDefault(c,0)+1);
10        }
11        for(i =0;i<n;i++){
12            if(freq.get(s.charAt(i))==1){
13                return i;
14            }
15        }
16        return -1;
17    }
18}