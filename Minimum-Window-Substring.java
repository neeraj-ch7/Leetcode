1class Solution {
2    public String minWindow(String s, String t) {
3        
4        if(s.length() < t.length()) return "";
5
6        int[] freq = new int[256];
7        for(char ch : t.toCharArray()){
8            freq[ch]++;
9        }
10
11        int low=0;
12        int minl=Integer.MAX_VALUE;
13        int count = t.length();
14        int start = 0;
15        
16        for(int high=0;high<s.length();high++){
17            char right = s.charAt(high);
18            if(freq[right]>0){
19                count--;
20            }
21            freq[right]--;
22
23            while(count == 0){
24              if(high-low +1 < minl){
25                minl = high-low+1;
26                start =low;
27              }
28              char left = s.charAt(low);
29              freq[left]++;
30
31              if(freq[left]>0){
32                count++;
33              }
34            low++;
35            }
36        }
37        if(minl==Integer.MAX_VALUE){
38            return "";
39        }     
40       return s.substring(start,start+minl);
41    }
42}