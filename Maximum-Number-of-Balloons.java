1class Solution {
2    public int maxNumberOfBalloons(String text) {
3
4        HashMap<Character,Integer> have = new HashMap<>();
5        HashMap<Character,Integer> need = new HashMap<>();
6       
7        int i;
8
9        for(i =0;i<text.length();i++){
10            char c = text.charAt(i);
11            have.put(c,have.getOrDefault(c,0)+1);
12        }
13        need.put('b',1);
14        need.put('a',1);
15        need.put('l',2);
16        need.put('o',2);
17        need.put('n',1);
18
19        int res = Integer.MAX_VALUE;
20     
21        for (char c : need.keySet()) {
22
23             int fneed = need.get(c);
24             int fhave = have.getOrDefault(c, 0);
25             int times = fhave/fneed;
26            
27             res = Math.min(res,times);
28     
29       }
30       return res;
31   }
32
33}