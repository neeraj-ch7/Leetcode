1class Solution {
2
3    public boolean fun(HashMap<Character, Integer> need,
4                   HashMap<Character, Integer> have) {
5
6        for (char c : need.keySet()) {
7
8            int fneed = need.get(c);
9            int fhave = have.getOrDefault(c, 0);
10
11            if (fhave < fneed) {
12                 return false;
13            }
14        }
15
16        return true;
17}
18
19    public boolean canConstruct(String ransomNote, String magazine) {
20        HashMap<Character,Integer> need = new HashMap<>();
21        HashMap<Character,Integer> have = new HashMap<>();
22
23        int i ;
24
25        for(i=0;i<ransomNote.length();i++){
26            char c = ransomNote.charAt(i);
27            need.put(c,need.getOrDefault(c,0)+1);
28        }
29        for(i=0;i<magazine.length();i++){
30            char c = magazine.charAt(i);
31            have.put(c,have.getOrDefault(c,0)+1);
32        }
33
34       return fun(need,have);
35    }
36}