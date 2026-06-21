1class Solution {
2    public int longestPalindrome(String s) {
3        
4      HashMap<Character,Integer> need = new HashMap<>();
5      int res =0;
6      int i;
7      boolean odd= false;
8
9      for(i=0;i<s.length();i++){
10        char c = s.charAt(i);
11        need.put(c,need.getOrDefault(c,0)+1);
12      }
13
14      for(char c : need.keySet()){
15        int f= need.get(c);
16
17        if(f%2==0){
18          res +=f;
19        }
20        if(f%2==1){
21            res += f-1;
22            odd =true;
23        }  
24      }
25
26      if(odd == false){
27        return res;
28      }
29
30      return res+1;
31
32    }
33}